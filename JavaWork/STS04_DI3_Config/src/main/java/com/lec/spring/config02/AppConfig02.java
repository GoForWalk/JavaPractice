package com.lec.spring.config02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.lec.spring.bean.Score;
import com.lec.spring.bean.Student;

// Java 클래스를 이용한 설정
// class 이름 앞에 반드시 annotation 필요하다.
// @Configuration --> 이 클래스는 '스프링 설정'에 사용되는 클래스 입니다.

// 결국 컨테이너 역할(?) 을 함.

@Configuration
public class AppConfig02 {
	
	@Bean
	public Score score1() { // 메소드 이름 score1 이 bean 의 name 값 (id값)이 된다.
		return new Score(100, 85, 75, "나이스");
	}
	
	@Bean
	public Student stu1() {
		return new Student("훈지예지", 34, score1());
	}
	
	
	
	
}






