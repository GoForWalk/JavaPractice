package 배열1.자가진단04;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int[] numArr = new int[100];
		int count = 0;
		
		for (int i = 0; i < 100; i++) {
			int k = sc.nextInt();
			if(k == 0)break;
			else {
			numArr[i] =  k;
			count++;
			}
		}
		sc.close();
		
		if(count != 100) {
			for (int i = count; i > 0; i--) {
				System.out.print(numArr[i - 1] + " ");
			}
		} else {
			for (int i = count; i > 0; i--) {
				System.out.print(numArr[i] + " ");
			}
		}
		
	}
}
