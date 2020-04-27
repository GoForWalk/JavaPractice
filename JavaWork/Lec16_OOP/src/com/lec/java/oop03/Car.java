package com.lec.java.oop03;

public class Car extends Vehicle{
	private int oil;

	public final int getOil() {
		return oil;
	}

	public final void setOil(int oil) {
		this.oil = oil;
	}
	
	@Override
	public void displayInfo() {
		System.out.println("--- Car 정보 ---");
		System.out.println("speed: " + getSpeed());
		System.out.println("oil: " + oil);
	}
}
