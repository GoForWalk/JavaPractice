package 배열1.형성평가04;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int [] intArr = new int[100];
		int count = 0;
		int temp = 0;
		
		for (int i = 0; i < intArr.length; i++) {
			temp = sc.nextInt();
			if(temp == -1)break;
			
			intArr[i] = temp;
			count++;
		}
		sc.close();
		
			if(count < 3) {
				for (int i = 0; i < count; i++) {
					System.out.print(intArr[i] + " ");
				}
			} else {
				for (int i = count -3; i < count; i++) {
					System.out.print(intArr[i] + " ");
			}
		}
		
	}
}
