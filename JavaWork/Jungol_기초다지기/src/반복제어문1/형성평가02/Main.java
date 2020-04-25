package 반복제어문1.형성평가02;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		int i = 0;
		int odd = 0;
		int even = 0;
		boolean b = true;
				
		while(b) {
			i = Integer.parseInt(sc.next());
			if(i == 0)break;
			
			if(i % 2 == 0) {
				even++;
			} else {
				odd++;
			}
		}
		
		System.out.println("odd : " + odd);
		System.out.println("even : " + even);
		
		
	}

}
