package 반복제어문2.형성평가04;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int number = sc.nextInt();
		int mainNumber = 0;
		int total = 0;
		double avg = 0.0;
		
		for (int i = 0; i < number; i++) {
			mainNumber = sc.nextInt();
			total += mainNumber;
		}
		sc.close();
		avg = (double)total / number;
		System.out.println(String.format("%.2f", avg));
		
	}
}
