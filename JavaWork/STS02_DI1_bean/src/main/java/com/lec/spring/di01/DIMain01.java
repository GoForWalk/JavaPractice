package com.lec.spring.di01;

import com.lec.spring.MessageBean;
import com.lec.spring.MessageENG;

public class DIMain01 {

	
	/*
	 *  Dependency Injection (DI, 의존주입)
	 *  
	 *  필요한 객체를 '누가' 만들어 사용하나
	 *  
	 *  방법1: 직접 생성(new)하여 사용
	 * 
	 * 
	 */
	
	public static void main(String[] args) {

		System.out.println("Main 시작");
		MessageBean msg = null;
		
//		msg = new MessageKOR(); // 직접 만들어서 사용
//		msg.sayHello();
		
		// 의존하고 있는 객체의 버젼등이 업그레이드 되면(설계변경이 되면)
		// 의존하고 있던 객체를 재컴파일 해야한다. (수정해야 한다!)
		msg = new MessageENG();
		msg.sayHello();
		
		System.out.println("Main 종료");
	}

}
