package 반복제어문3.형성평가07;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		int charNum = 65;
		int intNum = 0;
		
		sc.close();
		
		for (int i = 1; i <= num; i++) {
			
			for (int j = num; j >= i ; j--) {
				char a = (char)charNum;
				System.out.print(a + " ");
				charNum++;
			}
			for (int j = 1; j < i; j++) {
				System.out.print(intNum + " ");
				intNum++;
			}
			System.out.println();
		}
	}

}
