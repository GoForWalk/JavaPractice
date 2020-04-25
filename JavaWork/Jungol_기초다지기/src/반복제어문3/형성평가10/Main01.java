package 반복제어문3.형성평가10;

import java.util.Scanner;

public class Main01 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		int odd = 0;
		int count = 0;
		
		for (int i = 1; i <= num; i++) {
			for (int j = 1; j <= num; j++) {
				odd = (count * 2) + 1;
				count++;
				if(count > 4) count = 0;
				System.out.print(odd + " ");
			}
			System.out.println();
		}
	}

}
