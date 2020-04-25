package 반복제어문1.형성평가05;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int base = 0;
		int height = 0;
		double triangleWidth = 0;
		String con = "";
				
		while(true) {
			System.out.print("Base = ");
			base = sc.nextInt();
			
			System.out.print("Height = ");
			height = sc.nextInt();
			
			triangleWidth = ((double)base * height)/2;  
			System.out.print("Triangle width " + triangleWidth);
			System.out.print("\nContinue? ");
			con = sc.next();
			
			if(con.equals("N")) {
				break;
			}
		}
		
	} // main() end

}//class end
