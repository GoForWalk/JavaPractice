package 반복제어문3.자가진단07;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		int charNum = 65;
		int intNum = 0;
		
		sc.close();
		
		for (int i = 1; i <= num ; i += num) {
			
			for (int j = 1; j <= num; j++) {
				
				for (int k = num; k >= j; k--) {
					intNum++;
					System.out.print(intNum + " ");
				}
				for (int k = 1; k <= j; k++) {
					char a = (char)charNum;
					System.out.print(a + " ");
					charNum++;
				}
				System.out.println();
			}
		}
		
	}
}
