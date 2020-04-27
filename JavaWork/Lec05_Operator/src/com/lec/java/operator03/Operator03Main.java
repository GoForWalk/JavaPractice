package com.lec.java.operator03;

/* 부호연산자(+, -) sign operator
 * 	+: 부호 연산자(수의 부호(양,음)가 바뀌지 않음)
 * 	-: 부호 연산자(수의 부호(양,음)가 바뀜)
 */
// 대표적인 단항 연산자
public class Operator03Main {

	public static void main(String[] args) {
		System.out.println("연산자 3 - 부호연산자(+, -) sign operator");

		int num1 = -10; // 부호연산자도 연산자 이다. 따라서 연산자 2개
		int num2 = +num1;
		int num3 = -num1;

		System.out.printf("num1: %d\nnum2: %d\nnum3: %d\n", num1, num2, num3);

		int num4 = 11;
		int num5 = -22;
		int num6 = num4 + -num5; // 연산자 3개
		System.out.println("num6 = " + num6);

		int num7 = num4 - -num5;
		System.out.println("num7 = " + num7);

		System.out.println("\n프로그램 종료");
	} // end main

} // end class
