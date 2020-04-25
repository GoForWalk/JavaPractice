package 반복제어문2.형성평가02;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int maxNum = 0;
		int minNum = 0;
		int temp;
		
		maxNum = sc.nextInt();
		minNum = sc.nextInt();
		
		sc.close();
		
		if(maxNum < minNum) {
			temp = maxNum;
			maxNum = minNum;
			minNum = temp;
		}
		for (int i = minNum; i <= maxNum; i++) {
			System.out.print(i + " ");
		}
		
	}
}
