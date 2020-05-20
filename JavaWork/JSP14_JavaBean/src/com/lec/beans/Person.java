package com.lec.beans;

public class Person {
	private String name;
	private int age;
	private int id;
	private String gender;
	
	
	
	// Person bean 객체 정의
	
	// 기본생성자
	public Person() {
		super();
	}
	
	// 매개변수 생성자
	public Person(String name, int age, int id, String gender) {
		super();
		this.name = name;
		this.age = age;
		this.id = id;
		this.gender = gender;
	}

	// getter / setter 
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
		
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	
}
