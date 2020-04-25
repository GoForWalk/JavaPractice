package 반복제어문1.형성평가03;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int i = 0;
		int sum = 0, cnt = 0;
		double avg;
		
		while(true) {
			i = sc.nextInt();
			if(i > 100)break;
			cnt++;
			sum += i;
		}
		avg = (double)sum / cnt;
		
		System.out.println("sum : " + sum);
		System.out.printf("avg : %.1f",avg);

		sc.close();
	}
	
}
