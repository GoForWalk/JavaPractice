package practice.isogram;

import java.util.Arrays;
import java.util.Scanner;

/*	Isogram
	 문자열을 입력받으면 isogram 여부를 판단하여 true/false 를 출력하다가, quit 가 입력되면 종료
	isogram 이란?  : 중복된 알파벳이 없는 단어
	
	 isogram 예) Machine, isogram, Alphabet, quit
 */
public class Isogram {

	public static boolean isIsogram(String line) {
		
		line = line.toLowerCase();
		for (int i = 0; i < line.length(); i++) {
			if(line.substring(i + 1).indexOf(line.charAt(i)) != -1) return false;
		}
		return true;
		
		
	}
  
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);

    	while(true) {
    		
    		String line = sc.nextLine();
    		if(line.trim().equalsIgnoreCase("quit"))break;
    		    		
    		
    		System.out.println(isIsogram(line));
    		
    	} //while문 end
    	
    	sc.close();
    } // end main()
} // end class
 