package com.lec.java.inherit07;

public class BusinessPerson extends Person {
	
	private String company;

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Override
	public void showInfo() {
		// TODO Auto-generated method stub
		super.showInfo(); // 부모의 showInfo 사용
		System.out.println("회사: " + company);
	}
	
	@Override
	public String toString() { // 이 객체를 문자열로 표현할 때 사용
		// TODO Auto-generated method stub
		return "BusinessPerson: " + getName() + " " + company;
	}
	
	
	// 메소드 재정의(overriding)
	public void showInfo(int id) {
		// TODO Auto-generated method stub
		System.out.println("id: " + id);
		showInfo(); 
	}
	
	//alt + shift + s, v
	
//	@Override
//	public void whoAreYou() {
//		// TODO Auto-generated method stub
//		super.whoAreYou();
//	}
	
	
}
