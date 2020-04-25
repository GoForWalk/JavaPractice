package 선택제어문.형성평가01;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		
		int result = num1 - num2;
		if(result < 0) {
			System.out.println(-1 * result);
		} else {
			System.out.println(result);
		}
		
	}
}
