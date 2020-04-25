package 선택제어문.자가진단06;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		String gender = sc.next();
		int age = sc.nextInt();
		
		sc.close();
		
		switch (gender) {
		case "F":
			if(age >= 18) {
				System.out.println("WOMAN");
			} else {
				System.out.println("GIRL");
			}
			break;
			
		case "M":
			if(age >= 18) {
				System.out.println("MAN");
			} else {
				System.out.println("BOY");
			}
			break;
		}
		
		
	} // main() end

}// class end
