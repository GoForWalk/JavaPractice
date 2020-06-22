package com.lec.spring.aop03;

import com.lec.beans.ServiceEX;

public class MyServiceEX32 extends ServiceEX{

	@Override
	public void doAction() {
		printInfo();
	}
	
	@Override
	public void doWorking() {
		printInfo();		
	}
	
	@Override
	public void quitAction() {
		printInfo();		
	}
}
