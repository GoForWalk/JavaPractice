package 반복제어문3.형성평가06;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		sc.close();
		
		for (int i = 1; i <= num ; i++) {
			int k = 0;
			
			for (int j = ((num - i)  * 2); j >= 1 ; j--) {
				System.out.print(" ");
			}
			for (int j = 1; j <= i; j++) {
				k++;
				System.out.print(k + " ");
			}
			System.out.println();
		}
	}

}
