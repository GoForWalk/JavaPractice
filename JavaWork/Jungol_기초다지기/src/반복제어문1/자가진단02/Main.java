package 반복제어문1.자가진단02;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int i = sc.nextInt();
		int num = 1;
		int result = 0;
		
		while(num <= i) {
			result += num;
			num++;
		}
		System.out.println(result);
		
	}

}