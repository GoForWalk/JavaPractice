package com.lec.spring.di03;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.lec.spring.Score;

public class DIMain03 {

	public static void main(String[] args) {
		System.out.println("Main 시작");
		
		// AbstractApplicationContext (컨테이너) 생성, (빈(bean) 도 자동생성)
		AbstractApplicationContext ctx = 
					new GenericXmlApplicationContext("classpath:scoreCtx.xml");
		System.out.println("컨테이너 생성\n");
		
		Score score = null;
		
		score = ctx.getBean("myScore1", Score.class);
		System.out.println(score);
		
		score = (Score)ctx.getBean("myScore2"); // Object 타입으로 리턴 , 형변환해서 사용가능!!
		System.out.println(score);
		
		score = (Score)ctx.getBean("myScore3");
		System.out.println(score);
		
		score = (Score)ctx.getBean("myScore4");
		System.out.println(score);

		score = (Score)ctx.getBean("myScore5");
		System.out.println(score);

		score = (Score)ctx.getBean("myScore6");
		System.out.println(score);
		
		score = (Score)ctx.getBean("myScore7");
		System.out.println(score);
		
		score = (Score)ctx.getBean("myScore8");
		System.out.println(score);

		System.out.println("생성된 빈의 갯수: " + ctx.getBeanDefinitionCount());
		for (int i = 0; i < ctx.getBeanDefinitionCount(); i++) {
			System.out.println(ctx.getBean("myScore" + i));
		}
		
		
		ctx.close();
		System.out.println("Main 종료");
		
	}

}



























