package com.lec.java.dowhile;

/*
do {
	...
	...
}while(조건식) 문인 경우에는,

{...} 안에 있는 실행문들을 한번은 실행을 하고 나서
조건식을 검사하게 된다.

*/

public class While04Main {

	public static void main(String[] args) {
		System.out.println("do ~ while문 연습");
		// 한번은 무조건 실행!! 그 다음 조건식 검사!!!
		
		int n = 0;
		while(n > 0) {
			System.out.println("카운트 다운: " + n);
			n--;
		}
		//한번도 안찍힘!!
		System.out.println();
		
		n = 0;
		do {
			System.out.println("카운트 다운: " + n);
			n--;
		} while(n > 0);
		
		System.out.println();
		
		// 구구단 9단 do ~ while 로!
		int i = 1;
		do {
			System.out.println("9 X " + i + " = " + i * 9);
			i++;
		} while(i <= 9);
		
		
		
	} // end main()

} // end class While04Main









