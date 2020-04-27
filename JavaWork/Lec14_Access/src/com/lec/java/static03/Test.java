package com.lec.java.static03;

public class Test {
	private int num;
	
	static int count = 0;

	//	Singleton 패턴
	// 기본 생성자
	private Test() { // pirvate으로 접근 제어
		count++;
		System.out.println(count + "번째 인스턴스 생성");
	}

	private static Test instance = null;
	
	public static Test getInstance() {
		if(instance == null) {
			instance = new Test();
		}
		return instance;
	}
	
	// getter & setter
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
}
