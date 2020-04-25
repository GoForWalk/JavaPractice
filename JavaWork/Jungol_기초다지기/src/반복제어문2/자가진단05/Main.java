package 반복제어문2.자가진단05;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] intArr = new int[10];
		int multi3Cnt = 0;
		int multi5Cnt = 0;
		
		for (int i = 0; i < intArr.length; i++) {
			intArr[i] = sc.nextInt();
			
			if(intArr[i] % 3 == 0) {
				multi3Cnt++;
			}
			if(intArr[i] % 5 == 0) {
				multi5Cnt++;
			}
			
		}
		sc.close();
		System.out.println("Multiples of 3 : " + multi3Cnt );
		System.out.println("Multiples of 5 : " + multi5Cnt );
		
	}
}
