package 배열1.형성평가09;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int count = 0;
		int [] intArr = new int [100];
		
		for (int i = 0; i < intArr.length; i++) {
			int temp = sc.nextInt();
			if(temp == 0)break;
			else {
				count++;
				intArr[i] = temp;
			}
			if(intArr[i] % 2 != 0) {
				intArr[i] *= 2;
			}else if(intArr[i] % 2 == 0) {
				intArr[i] /= 2; 
			}
		}
		sc.close();
		System.out.println(count);
		for (int i = 0; i < count; i++) {
			System.out.print(intArr[i] + " ");
		}
	}
}
