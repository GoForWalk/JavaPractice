package 배열1.형성평가07;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int [] intArr = new int[100];
		int temp = 0;
		int min = 0;
		int max = 0;
		
		for (int i = 0; i < intArr.length; i++) {
			temp = sc.nextInt();
			if(temp == 999)break;
			if(i == 0) {
				min = temp;
				max = temp;
			}
			min = min < temp ? min : temp;
			max = max > temp ? max : temp;
			
		}
		sc.close();
		System.out.println("max : " + max);
		System.out.println("min : " + min);
	}

}
