package 반복제어문1.자가진단06;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int i = 0;
		boolean b = true;
		
		while(b) {
			
			System.out.println("1. Korea");
			System.out.println("2. USA");
			System.out.println("3. Japan");
			System.out.println("4. China");
			System.out.print("number? ");
			i = sc.nextInt();
			
			System.out.println();
			
			
			switch (i) {
			case 1:
				System.out.println("Seoul");
				break;
			case 2:
				System.out.println("Washington");
				break;
			case 3:
				System.out.println("Tokyo");
				break;
			case 4:
				System.out.println("Beijing");
				break;
			default: 
				System.out.println("none");
				break;
			}
			if(i < 1 || i > 4) break;
			
			System.out.println();
			
			
		}
		
	} // main() end
} // class end