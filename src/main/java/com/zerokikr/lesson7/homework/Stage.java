package com.zerokikr.lesson7.homework;

public abstract class Stage {
	protected int length;
	protected String description;
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public abstract void go (Car c);
	
}
