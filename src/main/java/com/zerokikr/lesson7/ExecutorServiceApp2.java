package com.zerokikr.lesson7;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceApp2 {
	
	public static void main(String[] args) {
		
		ExecutorService service = Executors.newFixedThreadPool(4);
		
		Future<String> stringFuture = service.submit(new Callable<String>() {//изначально Callable<T> - обобщенный тип, нужно указать что он будет возвращать 	
			@Override
			public String call () throws Exception {
				Thread.sleep(2000);
				//int x = 10/0;
				return "Java";
			}
		});
		
		try {
			String result = stringFuture.get(); //метод .get() работает по аналогии с join(), т.е. ждет пока тред отработает задачу.
			System.out.println(result); 
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();;
		}
		
		service.shutdown();
	}
	
}
