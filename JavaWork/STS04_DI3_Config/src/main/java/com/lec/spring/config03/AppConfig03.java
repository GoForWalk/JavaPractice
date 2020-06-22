package com.lec.spring.config03;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.lec.spring.bean.Score;

@Configuration
public class AppConfig03 {
	
	@Bean
	public Score score1() { // id "score1" 의 Score 반영
		return new Score(60, 40 ,45, "too bad");
	}
	
}
