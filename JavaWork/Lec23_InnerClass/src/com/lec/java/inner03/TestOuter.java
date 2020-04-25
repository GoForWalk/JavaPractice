package com.lec.java.inner03;

public class TestOuter {
	private int value; // outer value
	
	public TestOuter(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
	// 멤버 내부 클래스
	
	public class TestInner {
		private int value; // inner value
		
		public TestInner(int value) {
			this.value = value;
		}
		
		public void printValue() {
			int value = 10; // 3. 지역변수 value
			System.out.println("value = " + value);
			System.out.println("this.value = " + this.value);
			System.out.println("TestOuter.this.value = " + TestOuter.this.value);
		} 
		
	}

} // end class TestOuter














