package 배열1.형성평가06;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		char [] charArr = {'J', 'U', 'N', 'G', 'O', 'L'};
		
		Scanner sc = new Scanner(System.in);
		
		String input = sc.next();
		int result = -1;
		sc.close();
		
		for (int i = 0; i < charArr.length; i++) {
			if(charArr[i] == input.charAt(0)){
				result = i;
				System.out.println(result);
			} else continue;
		}
		if(result == -1)System.out.println("none");
		
	}
}
