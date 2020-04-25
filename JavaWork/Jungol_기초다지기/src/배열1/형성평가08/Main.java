package 배열1.형성평가08;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		int count = 0;
		double avg = 0.0;
		
		int [] intArr = new int[100];
		
		for (int i = 0; i < intArr.length; i++) {
			intArr[i] = sc.nextInt();
			if(intArr[i] == 0) break;
			
			if(intArr[i] % 5 == 0) {
				count++;
				sum += intArr[i];
			}
		}
		avg = (double)sum / count;
		System.out.println("Multiples of 5 : " + count);
		System.out.println("sum : " + sum);
		System.out.println("avg : " + String.format("%.1f", avg));
	
	}

}
