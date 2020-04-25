package 반복제어문3.자가진단04;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String blank = " ";
		
		int num = sc.nextInt();
		sc.close();
		
		for (int i = num ; i >= 1; i--) {
			
			for (int j = 0; j < (num - i); j++) {
				System.out.print(blank);
			}
			
			
			for (int j = i; j >= 1; j--) {
				System.out.print("*");
			}
			System.out.println();
		}		
		
		
	}

}
