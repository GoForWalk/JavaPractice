package 배열1.형성평가05;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		double sum = 0;
		double [] doubleArr = new double[6];
		
		for (int i = 0; i < doubleArr.length; i++) {
			doubleArr[i] = sc.nextDouble();
			sum += doubleArr[i];
		}
		sc.close();
		System.out.printf("%.1f",sum/doubleArr.length);
	}

}
