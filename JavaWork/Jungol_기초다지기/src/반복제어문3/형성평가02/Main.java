package 반복제어문3.형성평가02;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		int count = 0;
		int result = 0;
		sc.close();
		if(num > 100)return;
		
		while(true) {
			count++;
			result = count * num;
			if(result > 100)break;
			System.out.print(result + " ");
			if(result % 10 == 0)break;
			
		}
	}

}
