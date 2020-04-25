package 반복제어문1.자가진단04;
// 1 2 3 4 5 6 7 8 9 10 100


import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		
		int i = 0;
		int cnt = 0;
		int sum = 0;
		boolean b = true;
		double avg = 0;
		
		while(b) {
			cnt++;
			i = sc.nextInt();
			sum += i;
			if(i >= 100) break;
		}
		avg = (double)sum / cnt; //계산 형변환
		
		System.out.println(sum);
		System.out.println(String.format("%.1f", avg));
		
		sc.close();
	}

}
