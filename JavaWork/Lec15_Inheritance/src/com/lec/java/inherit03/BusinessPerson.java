package com.lec.java.inherit03;

public class BusinessPerson extends Person {
	// 하나의 부모로 부터 상속받을 수 있다!! (단일 상속)
	// c++은 다중상속 가능
	
	String company;
	
	public void showInfo() {
		whoAmI();
		System.out.println("회사는 " + company + " 입니다.");
	}
	
	
}
