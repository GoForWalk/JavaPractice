package 배열1.자가진단08;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int [] intArr = new int[10];
		int evenSum = 0;
		int oddSum = 0;
		int count = 0;
		double avg = 0.0;
		
		for (int i = 0; i < intArr.length; i++) {
			intArr[i] = sc.nextInt();
			
			if(i % 2 != 0) {
				evenSum += intArr[i];
			} else if (i % 2 == 0) {
				oddSum += intArr[i];
				count++;
			}
		}
		sc.close();
		
		avg = (double)oddSum / count;
		System.out.println("sum : " + evenSum);
		System.out.println("avg : " + String.format("%.1f", avg));
		
	}

}
