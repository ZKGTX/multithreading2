package com.zerokikr.lesson7;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierApp {

	public static void main(String[] args) {
		final int THREADS_COUNT = 5;
		
		CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
		
		for (int i = 0; i < THREADS_COUNT; i++) {
			int w = i+1 ;
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						System.out.println("��������� " + w);
						Thread.sleep(2500 + 500 * (int) (Math.random()*10));
						System.out.println(w + " �����");
						cyclicBarrier.await();
						System.out.println(w + " �����!!");
					} catch (InterruptedException | BrokenBarrierException e) {
						e.printStackTrace();
					}
				}
			}).start();
		}
	}

}
