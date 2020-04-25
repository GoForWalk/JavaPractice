package 배열1.자가진단01;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String [] strArr = new String[10];
		
		for (int i = 0; i < strArr.length; i++) {
			strArr[i] = sc.next();
			
			System.out.print(strArr[i]);
		}
		
		sc.close();
		
	}

}
