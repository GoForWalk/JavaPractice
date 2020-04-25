package 선택제어문.형성평가04;
// 이상함;;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		System.out.print("number? ");
		int i = sc.nextInt();
		
		switch (i) {
		case 1:
			System.out.print("dog");
			break;
		case 2:
			System.out.print("cat");
			break;
		case 3:
			System.out.print("chick");
			break;

		default:
			System.out.print("I don't know");
			break;
		}
	}
	
}
