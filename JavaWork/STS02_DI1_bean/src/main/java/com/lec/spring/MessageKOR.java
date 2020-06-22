package com.lec.spring;

public class MessageKOR implements MessageBean {

	String msgKOR = "안녕하세요";
	
	// 생성자 : 언제 생성되는지 예의 주시
	public MessageKOR() {
		System.out.println("MassageKOR() 생성");
	}

	@Override
	public void sayHello() {
		System.out.println(msgKOR);
		
	}

}
