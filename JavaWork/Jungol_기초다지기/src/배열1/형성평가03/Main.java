package 배열1.형성평가03;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int [] intArr = new int[10];
		int oddSum = 0;
		int evenSum = 0;
				
		for (int i = 0; i < intArr.length; i++) {
			intArr[i] = sc.nextInt();
			if(i % 2 == 0) {
				oddSum += intArr[i];
			} else if(i % 2 != 0) {
				evenSum += intArr[i];
			}
		}
		sc.close();
		System.out.println("odd : " + oddSum);
		System.out.println("even : " + evenSum);
		
	}

}
