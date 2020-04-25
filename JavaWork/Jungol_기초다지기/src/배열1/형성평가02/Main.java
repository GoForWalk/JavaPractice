package 배열1.형성평가02;
/*
 * 5개의 정수를 입력받은 후 첫 번째 세 번째 다섯 번째 입력받은 정수의 합을 출력하는 프로그램을 작성하시오.


 * 15 20 33 10 9


	57
 */

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int [] intArr = new int[5];
		int sum = 0;
		
		for (int i = 0; i < intArr.length; i++) {
			intArr[i] = sc.nextInt();
			if(i % 2 == 0) {
				sum += intArr[i];
			}
		}
		System.out.println(sum);
		
	}
}
