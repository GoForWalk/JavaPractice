package com.lec.spring.di02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.lec.spring.MessageBean;

public class DIMainn02 {

	public static void main(String[] args) {
		System.out.println("Main 시작");
		
		// 스프링 설정파일 resource 명시
		String configLocation = "classpath:appCtx.xml";
		
		// 의존주입 ㄱㄱ!! 
		AbstractApplicationContext ctx =
				new GenericXmlApplicationContext(configLocation);
		System.out.println("Application Context 컨테이너 생성 완료");
		
		// 외부에서 만들어진 객체주입! (injection)
		MessageBean msg =
				ctx.getBean("messageBean", MessageBean.class);
		//					bean의 id 값 ,    bean 의 타입
		
		msg.sayHello();
		
		ApplicationContext ctx2;
		
		ctx.close(); // Application Context 컨테이너는 반드시 close()!
		
		System.out.println("Main 종료");
	}

}
