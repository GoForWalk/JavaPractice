package 반복제어문1.자가진단03;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int i = 0; 
		boolean b = true;
		
		while(b) {
			System.out.print("number? ");
			i = sc.nextInt();
			if( i == 0) {
				break;
			}else if(i > 0) {
				System.out.println("positive integer");
			}else {
				System.out.println("negative number");
			}
			
		}
		
	} // main() end
	
}// class end