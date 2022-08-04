package com.zerokikr.lesson7.homework;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

public class Car implements Runnable {
	
	private static int CARS_COUNT;
	private static Object winnerMonitor = new Object();
	private static boolean winner;

	
	static {
		CARS_COUNT = 0;
	}
	
	private Race race;
	private int speed;
	private String name;
	
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Car(Race race, int speed) {
		this.race = race;
		this.speed = speed;
		CARS_COUNT ++;
		this.name = "Участник № " + CARS_COUNT;
	}
	
	@Override
	public void run() {
		try {
			System.out.println(this.name + " готовится");
			Thread.sleep(500 + (int)(Math.random() * 800));
			System.out.println(this.name + " готов");
			MainApp.startCountDownlatch.countDown();
			MainApp.preparationCyclicBarrier.await();
			}
		catch (Exception e) {
			e.printStackTrace();
			}
		
		for (int i = 0 ; i < race.getStages().size(); i++) {
			race.getStages().get(i).go(this);
			}
		
		synchronized (winnerMonitor) {
			if (!winner) {
				winner = true;
				System.out.println(name + " ПОБЕЖДАЕТ В ГОНКЕ!");
			}
		}
		
		
		
		
		MainApp.finalCountDownlatch.countDown();

	}
}
