package 반복제어문2.자가진단06;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int classNum = sc.nextInt();
		int[] score = new int[classNum];
		int total = 0;
		
		for (int i = 0; i < score.length; i++) {
			score[i] = sc.nextInt();
			total += score[i];
		}
		
		double avg = (double)total / classNum;
		System.out.println("avg : " + String.format("%.1f", avg));
		
		if(avg >= 80) {
			System.out.println("pass");
		} else {
			System.out.println("fail");
		}
		
	}
}
