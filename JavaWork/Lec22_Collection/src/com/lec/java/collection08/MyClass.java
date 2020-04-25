package com.lec.java.collection08;

//Set 에서 같은지 다른지, 식별 가능하려면
//hashCode 와 equals 가 오버라이딩 되어야 한다
//hashCode() 값이 같고 equals() 결과가 true 이어야만 같은 객체로 판정한다.

public class MyClass {
	private int id;
	private String name;
	
	public MyClass() {}
	public MyClass(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void displayInfo() {
		System.out.println("학번: " + id);
		System.out.println("이름: " + name);
	}
	
	// TODO
	
	@Override
	public String toString() {
		return "학번: " + id + "\n" + "이름: " + name;
	}
	
	
	
	//Set 에서 같은지 다른지, 식별 가능하려면
	//hashCode 와 equals 가 오버라이딩 되어야 한다
	//hashCode() 값이 같고 equals() 결과가 true 이어야만 같은 객체로 판정한다.
	
	@Override
	public boolean equals(Object obj) { // 비교 대상 오브젝트
		
		MyClass other = (MyClass)obj;
		
		boolean result = (this.id == other.id) && (this.name.equalsIgnoreCase(other.name));

		return result;
	}
	
	@Override
	public int hashCode() {
		
		return this.id; // 고유한 정수 값을 지정하여 찾아낸다. ( 속도가 빠르다 )
	}
	
	
} // end class MyClass
