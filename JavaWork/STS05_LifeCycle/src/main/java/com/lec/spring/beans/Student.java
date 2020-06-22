package com.lec.spring.beans;

public class Student {

	String name;
	int age;
	Score score; // reference type
	public Student() {
		super();
		System.out.println("Student() 생성");
	}
	public Student(String name, int age, Score score) {
		super();
		this.name = name;
		this.age = age;
		this.score = score;
		System.out.printf("Student(%s, %d, %s) 생성\n" , name, age, score.toString());
	}
	public final String getName() {
		return name;
	}
	public final void setName(String name) {
		this.name = name;
	}
	public final int getAge() {
		return age;
	}
	public final void setAge(int age) {
		this.age = age;
	}
	public final Score getScore() {
		return score;
	}
	public final void setScore(Score score) { // 매개변수가 reference
		this.score = score;
	}
	
	@Override
	public String toString() {
		return String.format("[Student 이름:%s, 나이:%d, 성적:%s]",	name, age, score);
	}
	
	
}
