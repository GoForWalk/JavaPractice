package 반복제어문2.형성평가05;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int oddNumber = 0;
		int evenNumber = 0;
		int inputNumber;
		
		for (int i = 0; i < 10; i++) {
			inputNumber = sc.nextInt();
			if(inputNumber == 0)continue;
			
			if(inputNumber % 2 == 0) {
				evenNumber++;
			} else if(inputNumber % 2 == 1) {
				oddNumber++;
			}
		}
		
		sc.close();
		System.out.println("even : " + evenNumber);
		System.out.println("odd : " + oddNumber);
		
		
		
	}
}
