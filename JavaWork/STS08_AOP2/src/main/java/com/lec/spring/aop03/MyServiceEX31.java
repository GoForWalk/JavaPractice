package com.lec.spring.aop03;

import com.lec.beans.ServiceEX;

public class MyServiceEX31 extends ServiceEX{

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
