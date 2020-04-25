package 반복제어문1.형성평가04;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int num = 0;
		int cnt = 0;
		boolean b = true;
		
		while(b) {
			num = sc.nextInt();
			
			if(num == 0) break;
			if(num % 3 == 0 || num % 5 == 0) {
				continue;
			}
			cnt++;
			
		}
		System.out.println(cnt);
		
		
		sc.close();
	}

}
