package 배열1.형성평가01;

/*
 * 10개의 문자를 입력받아 마지막으로 입력받은 문자부터 첫 번째 입력받은 문자까지 차례로 출력하는 프로그램을 작성하시오.

	A E C X Y Z c b z e

 * e z b c Z Y X C E A

 * 
 */

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] intArr = new String[10];
		
		for (int i = 0; i < intArr.length; i++) {
			intArr[i] = sc.next();
		}
		sc.close();
		for (int i = intArr.length - 1 ; i >= 0; i--) {
			System.out.print(intArr[i] + " ");
		}
	}

}
