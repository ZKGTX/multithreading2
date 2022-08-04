package com.zerokikr.lesson7.homework;

import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {
	
	Semaphore tunnelEntrance = new Semaphore(MainApp.CARS_COUNT/2);

	public Tunnel() {
		this.length = 80;
		this.description = "������� " + length +  " ������";
	}
	
	@Override
	public void go (Car c) {
	try {
		try {
			System.out.println(c.getName() + " ��������� � �����(����): " + description);
			tunnelEntrance.acquire();
			System.out.println(c.getName() + " ����� ����: " + description);
			Thread.sleep(length / c.getSpeed() * 1000);
			}
		catch (InterruptedException e) {
			e.printStackTrace();
			}
		finally {
			System.out.println(c.getName() + " �������� ����: " + description);
			tunnelEntrance.release();

		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	}
	
}
