package 반복제어문3.형성평가09;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		int intNum = 0;
		sc.close();
		
		for (int i = 1; i <= num ; i++) {
			for (int j = num - i + 1 ; j < num; j++) {
				System.out.print(" ");
				System.out.print(" ");
			}
			for (int j = num; j >= i; j--) {
				intNum++;
				System.out.print(intNum + " ");
			}
			System.out.println();
		}
	}

}
