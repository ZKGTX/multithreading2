package com.zerokikr.lesson7;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample {
	
	public static void main(String[] args) {
		
		final Lock lock = new ReentrantLock();
		
		new Thread(new Runnable () {
			public void run() {
				System.out.println("t-before-lock-first");
				lock.lock();
				System.out.println("t-get-lock-first");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					System.out.println("t-end-first");
					lock.unlock();
				}

			}
		}).start();
		
	}

}
