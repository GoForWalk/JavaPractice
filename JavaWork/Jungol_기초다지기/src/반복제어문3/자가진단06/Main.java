package 반복제어문3.자가진단06;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		
		int charNum = 65;
		
		sc.close();
		
		for (int i = num; i >= 1; i--) {
			for (int j = i; j >= 1; j--) {
				char A = (char)charNum;
				System.out.print(A);
				charNum++;
			}
			System.out.println();
		}
		
	}

}
