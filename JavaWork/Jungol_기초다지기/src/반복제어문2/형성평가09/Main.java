package 반복제어문2.형성평가09;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		sc.close();
		
		for (int i = 1 ; i <= num; i+= num) {
			
			for (int j = 1; j <= num; j++) {
				
				 for (int k = 1; k <= num; k++) {
					System.out.printf("(%d, %d) ", j , k);
				}
				 System.out.println();
			}
			
		}
		
		
	}

}
