package 배열1.자가진단09;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int[] intArray = new int[10];
		
		for (int i = 0; i < intArray.length; i++) {
			intArray[i] = sc.nextInt();
			
		}
		sc.close();
		
		//cycle
		for (int i = intArray.length; i > 0 ; i--) {
			// 비교
			for (int j = 0; j < i - 1 ; j++) {
				
				if( intArray[j] < intArray[j + 1] ) {
					
					int temp = intArray[j];
					intArray[j] = intArray[j + 1];
					intArray[j + 1] = temp;
				}
			}
		}
		
		for (int i = 0; i < intArray.length; i++) {
			System.out.print(intArray[i] + " ");
		}
		System.out.println();
	}

}
