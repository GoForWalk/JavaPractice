package com.lec.java.hello;
/*
 * Java 첫 프로그램.
 * [학습목표]
 * - 기본 출력 : println(), print() 
 * - 주석 (Comment)
 */
public class Hello {

	public static void main(String[] args) {
		//프로그램 시작: 메인
		System.out.println("Hello Java!!"); //한줄 주석: line comment
		System.out.println("안녕하세요");//println() 은 화면 출력하고 줄바꿈.
		
		//.java(자바 소스 코드) : src 파일 안에 있다.
		//.class(byte code) : bin 파일 - 자바가 실행하는 파일, 자바가상머신 설치 기기에서 작동(플랫폼 독립)
		
		System.out.println();
		System.out.println(1 + 2);
		System.out.println("1" + "2");
		System.out.println('A' + 'B');
		System.out.println('1' + 2);
		System.out.println();
		System.out.println('J' + "ava");
		
//		print()는 출력하고 줄바꿈 안함.
		System.out.print("자바");
		System.out.print("프레임워크\n");
		System.out.println("플스텍 과정");
		System.out.println("2020-03-16");
	}

}
