package practice;

import java.util.Scanner;

public class Quiz02Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String i = sc.nextLine().substring(0, 1);
		String k = sc.nextLine().substring(0, 1);
		String j = sc.nextLine().substring(0, 1);
		
		System.out.println(i.concat(k).concat(j));

	}

}
