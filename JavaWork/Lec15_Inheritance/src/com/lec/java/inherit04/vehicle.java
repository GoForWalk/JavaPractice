package com.lec.java.inherit04;

public class vehicle {
 
	int speed;
	
	public vehicle() {
		System.out.println("Vehicle() 생성");
	}
	
	public vehicle(int speed) {
		this.speed = speed;
		System.out.println("Vehicle(int) 생성 : 속도 = " + speed);
	}
}
