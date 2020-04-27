package practice.capitalize;

import java.util.Scanner;

/* LetterCapitalize
 * 	문장을 입력하고,  단어의 앞 문자를 대문자로 만들어 출력하기를 반복하다가
 *  quit 을 입력 받으면 종료하기
 * 
 * 	[입력예]
 * 		hello my world
 *  [출력예]
 * 		Hello My World  
 */

public class LetterCapitalize {
	
		
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String[] inputArr;
		String input;
		
		while(true) {
			
			input = sc.nextLine();
			if(input.trim().equalsIgnoreCase("quit")) break;
			
			input = input.toLowerCase();
			inputArr = input.split(" ");
			
			for (int i = 0; i < inputArr.length; i++) {
				String firstLetter = inputArr[i].substring(0, 1).toUpperCase();
				String rest = inputArr[i].substring(1);
				System.out.print(firstLetter + rest + " ");
			}
		}
		System.out.println();
		
		
		
		sc.close();
	} // end main()
		
	
} // end class
