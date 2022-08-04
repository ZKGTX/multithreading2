package com.zerokikr.lesson7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;

public class ExecutorServiceApp3 {

	public static void main(String[] args) throws Exception {
		
		ExecutorService service = Executors.newFixedThreadPool(4, new ThreadFactory() {
			@Override
			public Thread newThread(Runnable r) {
				Thread t = new Thread(r);
				t.setPriority(10);
				//t.setDaemon(true);
				t.setName("ABC");
				System.out.println("created");
				return t;
			}
		});
		service.execute(() -> System.out.println(1));
		Thread.sleep(2000);
		service.execute(() -> System.out.println(2));
		Thread.sleep(2000);
		service.execute(() -> System.out.println(3));
		Thread.sleep(2000);
		service.execute(() -> System.out.println(4));
		Thread.sleep(2000);
		service.execute(() -> System.out.println(5));
		Thread.sleep(2000);
		service.execute(() -> System.out.println(6));
		Thread.sleep(2000);
		
		
		
		service.shutdown();
		
		ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
		
		

	}

}
