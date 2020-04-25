package 반복제어문2.형성평가10;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		sc.close();
			
			for (int i = 1; i <= 9; i+=9) {
				
				for (int j = 1; j <= 9; j++) {
					
					if(num1 > num2) {
						for (int k = num1; k >= num2; k--) {
							System.out.printf("%d * %d = %2d   ", k, j, (j*k));
						  }
					} 
					else {
						for (int k = num1; k <= num2; k++) {
							System.out.printf("%d * %d = %2d   ", k, j, (j*k));
						}
						
					}
					System.out.println();
				}
			} 
		
		
	} // end main()
	
} // end class


