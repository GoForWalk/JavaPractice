package com.lec.java.array04;

import java.util.Scanner;

/* 연습
 * 길이 5개 int 형 배열을 선언하고
 * 사용자로부터 5개 정수를 입력받아 초기화 한뒤 
 * 
 * 총점, 평균, 최대값, 최소값  출력해보기
 */
public class Array04Main {

	public static void main(String[] args) {
		System.out.println("배열 연습");
		
		Scanner sc = new Scanner(System.in);
		
		int num = 0;
		int[] intArray = new int[5];
		
		double avg;
		int total = 0;
		int max; 
		int min; 
		
		for (int i = 0; i < intArray.length; i++) {
			num = sc.nextInt();
			intArray[i] = num;
			total += intArray[i];	
			
		}
		avg = (double)total / intArray.length;
		
		max = intArray[0];
		for (int i = 1; i < intArray.length; i++) {
			if(intArray[i] > max)
				max = intArray[i];
		}
		
		//최솟값
		
//		min = intArray[0]; // 기준값 잡기
//		for (int i = 1; i < intArray.length; i++) {
//			if(intArray[i] < min)
//				min = intArray[i];
//		}
		
		min = intArray[0];
		for (int i = 0; i < intArray.length; i++) {
			min = intArray[i] < min ? intArray[i] : min;
		}
		
		System.out.println("총점: " + total);
		System.out.println("평균: " + String.format("%.2f", avg));
		System.out.println("최대값: " + max);
		System.out.println("최소값: " + min);
		
	} // end main()

} // end class Array04Main








