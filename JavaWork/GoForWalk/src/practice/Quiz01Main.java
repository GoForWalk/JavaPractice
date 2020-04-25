package practice;

import java.util.Scanner;

public class Quiz01Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		double i = sc.nextDouble();
		double j = sc.nextDouble();
		
		System.out.println(i + j);
		System.out.printf("%.1f", i * j);
	}

}
