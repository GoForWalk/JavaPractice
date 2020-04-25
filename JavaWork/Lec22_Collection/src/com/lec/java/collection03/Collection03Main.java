package com.lec.java.collection03;

import java.util.ArrayList;
import java.util.Scanner;

public class Collection03Main {

	public static void main(String[] args) {
		System.out.println("ArrayList 연습");
		
		//TODO:
		// Student 타입을 담는 ArrayList를 만드고
		// 사용자로부터 3개의 Student 데이터 을 입력받아서
		// 3가지 방법으로 출력해보세요. 
		// for, Enhanced-for, Iterator
		Scanner sc = new Scanner(System.in);
		
		int id;
		String name;
		Score s;
		int korScore = 0;
		int engScore = 0;
		int mathScore = 0;
		
		
		ArrayList<Student> stuList = new ArrayList<Student>();
		Score score = new Score();
		Student student = new Student();
		
		for (int i = 0; i < 3; i++) {
			System.out.println("id 입력");
			id = sc.nextInt();
			sc.nextLine();
			System.out.println("이름 입력");
			name = sc.nextLine();
			
			System.out.println("국어점수 입력");
			korScore = sc.nextInt();
			System.out.println("영어점수 입력");
			engScore = sc.nextInt();
			System.out.println("수학점수 입력");
			mathScore = sc.nextInt();
			
			Score(korScore, engScore, mathScore);
			
			Student(id, name, score);
			
			stuList.add(student);
			
//			Student stu = new Student(id, name, new Score(korScore,engScore,mathScore));
		}
		
		for (int i = 0; i < 3; i++) {
			System.out.println(stuList.get(i));
		}
		
		
		
		System.out.println("\n프로그램 종료");
	}

	private static void Student(int id, String name, com.lec.java.collection03.Score score) {
		// TODO Auto-generated method stub
		
	}

	private static void Score(int korScore, int engScore, int mathScore) {
		// TODO Auto-generated method stub
		
	} // end main()

} // end class









