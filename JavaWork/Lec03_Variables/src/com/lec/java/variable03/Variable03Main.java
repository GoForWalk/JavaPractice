package com.lec.java.variable03;

//실수형 자료 타입: float(4바이트), double(8바이트)
//정수형 자료 타입의 기본형은 int
//실수형 자료 타입의 기본형은 double

public class Variable03Main {
	
	public static void main(String[] args) {
		System.out.println("변수 - 실수타입");
		
		double number1 = 3.141592;
//		float number2 = 3.14;	//오류: Type mismatch: cannot convert from double to float
								// 기본적으로 실수 리터럴은 double로 인식
		// float <- double 대입 불가
		
		// float형 리터럴
		float number3 =3.14f;
		
		// 실수 타입 최소, 최댓값
		System.out.println("float : " + Float.MIN_VALUE + " ~ " + Float.MAX_VALUE);
		System.out.println("double : " + Double.MIN_VALUE + " ~ " + Double.MAX_VALUE);
		
		//	1.4 * 10^-45 ~ 
		// 	실수 값에서 최소값의 의미 : 얼마나 소수점을 찍을 수 있느냐 = 최소값이 음수가 아니다.
		
		//	실수 타입은 정확한 값을 기대할  수 없다. (정밀도의 문제)
		float number4 = 1.23456789f;	// 소숫점 아래 6자리
		double number5 = 1.23456789;	// 소숫점 아래 13자리
		System.out.println("number4 = " + number4);
		System.out.println("number5 = " + number5);
		// float 와 double은 저장할 수 있는 값의 크기 만이 아니라
		// 소숫점 이하 정밀도(precision)의 차이가 있다.
		
		// 실수 표기법
		double number6 = 123; //자동 형변환 된다. 123.0
		double number7 = 1.23e2; // 지수 표기법 (exponential notation)
		System.out.println("number6 = " + number6);
		System.out.println("number7 = " + number7);
		
		double number8 = 0.001213;
		double number9 = 1.1213E-4;
		System.out.println("number8 = " + number8);
		System.out.println("number9 = " + number9);
		
	} //end Main()
	
} //end class
