package 반복제어문3.형성평가01;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int num = 0;
		int sum = 0;
		int avg = 0;
		int count = 0;
		
		for (int i = 0; i < 100; i++) {
			num = sc.nextInt();
			
			if(num == 0) break;
			
			count++;
			sum += num;
		}
			sc.close();
			avg = sum / count;
			
			System.out.println(sum + " " + avg);
		
	}

}
