package com.lec.java.loop03;

public class Loop03Main {

	public static void main(String[] args) {
		System.out.println("중첩 for 문 nested for");

		for (int dan = 1; dan <= 9; dan++) {
			System.out.println(dan + "단");
			for (int n = 1; n <= 9; n++) {
				System.out.println(dan + " X " + n + " = " + (dan * n));
			}
			System.out.println();
		}
		
		System.out.println();
		// 구구단 출력 : 중첩 while 문 사용

		int dan = 1;
		while(dan <= 9) {
			int n = 1; //**
			System.out.println(dan + "단");
			while(n <= 9) {
				System.out.println(dan + " X " + n + " = " + (dan * n));
				n++;
			}
			
			System.out.println();
			dan++;
		}
		
		
		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class


















