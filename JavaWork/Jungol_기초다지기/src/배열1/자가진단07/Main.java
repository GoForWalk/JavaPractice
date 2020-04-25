package 배열1.자가진단07;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int [] intArr = new int[10];
		
		int maxNumUnder100 = 0;
		int minNumOver100 = 0;
		int temp = 0;
		int count = 0;
		int maxCount = 0;
		
		for (int i = 0; i < intArr.length; i++) {
			intArr[i] = sc.nextInt();
		}
		
		for (int i = 0; i < intArr.length; i++) {
			if(intArr[i] < 100) {
				maxCount++;
				temp = intArr[i];
				if(maxCount == 1) maxNumUnder100 = temp;
				else maxNumUnder100 = temp > maxNumUnder100 ? temp : maxNumUnder100;
				
			} else if(intArr[i] >= 100) {
				count++;
				temp = intArr[i];
				if(count == 1) minNumOver100 = temp;
				else minNumOver100 = temp < minNumOver100 ? temp : minNumOver100;
			}
		} 
		if(maxNumUnder100 == 0) maxNumUnder100 = 100;
		if(minNumOver100 == 0) minNumOver100 = 100;
 		System.out.println(maxNumUnder100 + " " + minNumOver100);
		sc.close();
	}

}
