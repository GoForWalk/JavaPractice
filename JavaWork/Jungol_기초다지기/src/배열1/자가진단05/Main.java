package 배열1.자가진단05;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		double [] intArr = {85.6 ,79.5, 83.1, 80.0, 78.2, 75.0};
		
		int lowClass = sc.nextInt() - 1;
		int highClass = sc.nextInt() - 1;
		int temp = 0;
		int sum = 0;
		sc.close();
		
		System.out.println(intArr[lowClass] + intArr[highClass]);
	}

}
