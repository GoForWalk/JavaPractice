package com.lec.java.access02;

public class Test02 {
	
	private int privateNum; //같은 클래스
	int defaultNum; // 같은 패키지
	protected int protectedNum; // 상속받은 클래스 + 자기자신
	public int publicNum;
	
	private void privateMethod() {}
	void defaultMethod() {}
	protected void protectedMethod() {}
	public void publicMethod() {}
	
	
	
	
	
	
}
