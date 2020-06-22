package com.lec.spring.aop01;

import com.lec.beans.Logger;
import com.lec.beans.Service;

public class MyService11 extends Service{

	@Override
	public void doAction() {
		new Logger().LogIn(); // 공통 기능
	
		// 핵심기능 수행
//		System.out.println("MyService11의 doAction()");
		printInfo();
		
		new Logger().LogOut(); // 공통기능
		
		
	}

}//end MyService
