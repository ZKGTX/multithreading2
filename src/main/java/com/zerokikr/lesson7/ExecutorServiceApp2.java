package com.zerokikr.lesson7;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceApp2 {
	
	public static void main(String[] args) {
		
		ExecutorService service = Executors.newFixedThreadPool(4);
		
		Future<String> stringFuture = service.submit(new Callable<String>() {//���������� Callable<T> - ���������� ���, ����� ������� ��� �� ����� ���������� 	
			@Override
			public String call () throws Exception {
				Thread.sleep(2000);
				//int x = 10/0;
				return "Java";
			}
		});
		
		try {
			String result = stringFuture.get(); //����� .get() �������� �� �������� � join(), �.�. ���� ���� ���� ���������� ������.
			System.out.println(result); 
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();;
		}
		
		service.shutdown();
	}
	
}
