package 반복제어문2.형성평가08;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int heng = sc.nextInt();
		int columm = sc.nextInt();
		sc.close();
		
		for (int i = 1; i <= heng; i+=heng) {
			
			for(int k = 1; k <= heng; k++) {
			
				for (int j = 1; j <= columm; j++) {
						System.out.print(k * j + " ");
				}
				System.out.println();
			}
		}

	}// end Main()

}// end class
