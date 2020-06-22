package com.lec.spring;

public class MessageENG implements MessageBean {

	String msgENG = "Good Morning";
	
	// 생성자
	public MessageENG() {
		System.out.println("MessageENG() 생성");
	}

	@Override
	public void sayHello() {
		System.out.println(msgENG);
	}

}
