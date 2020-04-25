package 배열1.자가진단06;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int [] intArr = new int[10];
		int minNum = 0;
		
		for (int i = 0; i < intArr.length; i++) {
			intArr[i] = sc.nextInt();
		}
		sc.close();
		minNum = intArr[0];
		
		for (int i = 1; i < intArr.length; i++) {
			
			minNum = minNum < intArr[i] ? minNum : intArr[i]; 
		}
		System.out.println(minNum);
	}

}
