package 반복제어문2.형성평가06;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		sc.close();
		int temp = 0;
		int sum = 0;
		double avg = 0.0;
		int count = 0;
		
		if(num1 > num2) {
			temp = num1;
			num1 = num2;
			num2 = temp;
		}
		
		for (int i = num1; i <= num2; i++) {
			
			if(i % 3 == 0) {
				count++;
				sum += i;
			}
			
			if(i % 5 == 0 && i % 3 != 0) {
				count++;
				sum += i;
			}
		}
		
		avg = (double)sum / count;
		
		System.out.println("sum : " + sum);
		System.out.println("avg : " + String.format("%.1f", avg));
		
	} // end main()

}// end class
