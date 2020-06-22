package com.lec.spring.config04;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import com.lec.spring.bean.Score;

@Configuration
@ImportResource("classpath:appCtx04.xml")
public class AppConfig04 {

	@Bean
	public Score score2() {
		return new Score(100, 80, 90 ,"올굳");
	}
}
