package 반복제어문3.자가진단01;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		int count = 0;
		int sum = 0;
		sc.close();
		
		while(true) {
			if(sum >= num)break;
			sum += (count * 2 + 1);
			count++;
		}
		System.out.println(count + " " + sum);
	}
}
