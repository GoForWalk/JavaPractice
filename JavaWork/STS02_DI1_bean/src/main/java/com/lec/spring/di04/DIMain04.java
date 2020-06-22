package com.lec.spring.di04;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.lec.spring.Student;

public class DIMain04 {

	public static void main(String[] args) {
		System.out.println("Main 시작");

		//컨테이너 생성
		GenericXmlApplicationContext ctx =
				new GenericXmlApplicationContext("classpath:StudentCtx.xml");
		System.out.println("컨테이너 생성");
		
		Student stu1 = (Student)ctx.getBean("Hong");
		System.out.println(stu1);
		
		Student stu2 = (Student)ctx.getBean("Joo");
		System.out.println(stu2);
		
		System.out.println();
		stu2.getScore().setKor(100);
		System.out.println(stu2);
		System.out.println(stu1);
		

		ctx.close();
		System.out.println("Main 종료");
	}

}
