package com.zerokikr.lesson7.homework;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class MainApp {
	
	public static final int CARS_COUNT = 4;
	
	final static CyclicBarrier preparationCyclicBarrier = new CyclicBarrier(CARS_COUNT);
	final static CountDownLatch startCountDownlatch = new CountDownLatch(CARS_COUNT);
	final static CountDownLatch finalCountDownlatch = new CountDownLatch(CARS_COUNT);

	public static void main(String[] args) {


		System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
		
		
		Race race = new Race(new Road(60), new Tunnel(), new Road(40));
		
		Car[] cars = new Car[CARS_COUNT];
		
		for (int i = 0 ; i < cars.length; i++) {
			cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
		}
		for (int i = 0 ; i < cars.length; i++) {
			new Thread(cars[i]).start();
		}
		try {
			startCountDownlatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
		
		
		
		try {
			finalCountDownlatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
	}

}
