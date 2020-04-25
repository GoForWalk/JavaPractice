package 선택제어문.자가진단09;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		int num3 = sc.nextInt();
		int result = 0;
		int result2 = 0;
		
		result = num1 < num2 ? num1 : num2;
		result2 = result < num3 ? result : num3;
		
		System.out.println(result2);
	}

}
