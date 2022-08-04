package com.zerokikr.lesson7;

public class ThreadException {
	
	public static void main(String[] args) {
		
		Thread t = new Thread (new Runnable() {
			public void run() {
				int x = 10;
				System.out.println(1);
				x = x/0;
				System.out.println(2);
			}
		});
		
		//Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
			// ����������� ����������, ���� ��� ���� ������
			//@Override
			//public void uncaughtException(Thread t, Throwable e) {
				
			//}
		//});
		
		t.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { 
			// ���������, ��� ������, ���� � ����� ������� Exception � ���� ��� �� ������
			// ��� ������� ����� ��������� ����� ����������
			@Override
			public void uncaughtException(Thread t, Throwable e) {
				e.printStackTrace();
				System.out.println("caught");
			}
		});
		
		t.start();
	}

}
