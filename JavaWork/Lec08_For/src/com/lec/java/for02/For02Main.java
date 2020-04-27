package com.lec.java.for02;

public class For02Main {

	public static void main(String[] args) {
		System.out.println("For문 - 구구단 출력");
		
		for (int i = 1; i <= 9 ; i++) {
			for (int j = 1; j <= 9 ; j++) {
				System.out.println( i + " X " + j + " = " + i * j);
			}
		}
		
		System.out.println();
		
		for (int i = 1; i <= 9 ; i++) {
			System.out.println( i + " X 4 = " + (4 * i));
		}
		System.out.println();
		
		for (int i = 2; i <= 9 ; i++) {
			System.out.println( i + " X " + i + " = " + (i * i));
		}
	} // end main()

} // end class For02Main












