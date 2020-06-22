package com.lec.beans;

public abstract class Service { // 추상 클래스 
	
	public abstract void doAction(); // 추상 메소드
	
	// 테스트용 : 메소드 호출정보 출력
	public void printInfo() {
		String className = this.getClass().getSimpleName(); // 메소드의 이름 출력
		StackTraceElement[] stackTrace = new Throwable().getStackTrace(); // 호출 계층정보
		String methodName = stackTrace[1].getMethodName(); // 현재 실행되고 있는 메소드 이름 -> [0]은 printinfo() 가 호출된다. [1]은 printInfo를 호출한 method
		System.out.println(className + " 의 " + methodName + "() 호출");
	}
	
	
}
