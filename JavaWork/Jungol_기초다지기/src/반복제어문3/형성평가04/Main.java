package 반복제어문3.형성평가04;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		sc.close();
		
		for (int i = num; i >= 1; i--) {
			
			for (int j = num ; j > i ; j--) {
				System.out.print(" ");
			}	
			
			for (int j = ((i * 2) - 1); j >= 1 ; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		for (int i = 1; i <= num -1; i++) {
			for (int j = i; j < num - 1; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= ((i * 2) + 1 ); j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
