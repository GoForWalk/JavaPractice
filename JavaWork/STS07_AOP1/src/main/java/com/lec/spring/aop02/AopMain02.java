package com.lec.spring.aop02;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.lec.beans.Service;

public class AopMain02 {

	public static void main(String[] args) {
		System.out.println("Main 시작");
		AbstractApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:aopCtx2.xml");
		System.out.println("ctx 생성");

		Service service21 = ctx.getBean("service21", Service.class);
		Service service22 = ctx.getBean("service22", Service.class);
		
		service21.doAction();
		System.out.println();
		service22.doAction();
		System.out.println();
		// 핵심기능 호출 안된다. (service에 공통기능이 없다) -> 공통기능 ASpect에서 만들어보자! 
		
		((MyService21)service21).hahaha();
		// 자동적으로 w
		
		ctx.close();
		System.out.println("Main 종료");
	} // end main

} // end class
