package com.lec.java.switch01;

/* switch - case 조건문
 * 
 * 	switch (조건값){
 * 	case 값1:
 * 		...
 * 	case 값2:
 * 		...
 *	default:
 *		...
 *	}
 *
 * 	해당 조건의 case문을 찾아서 거기서부터 break를 만날 때까지 실행을 함.
 *  break를 만나게 되면 switch 문장을 종료.
 *  해당하는 case가 없으면 default 문장을 실행함.
 *  
 *  	※ 모든 switch 조건문은 if - else if - else로 바꿀 수 있다. (할수 있어야 한다)
 */
public class Switch01Main {

	public static void main(String[] args) {
		System.out.println("switch 문");

		int num = 3;
		switch (num) {
		case 1: // num 값이 1 일때, 아래 문장들을 수행 ~~ break; 까지
			System.out.println("하나");
			System.out.println("ONE");
			break; //switch 안에서의 수행종료, break; 가 없을 때는 만날때까지 계속 수행한다.

		case 2:
			System.out.println("둘");
			System.out.println("TWO");
			break;
			
		case 3:
			System.out.println("셋");
			System.out.println("THREE");
			break;
			
		default: //해당사항 없지만, 작업을 수행할 때
			System.out.println("이도 저도 아님...");
			break;
		}
		//Switch 는 점프를 하기 때문에 성능이 더 좋다고 할수 있다.
		
		
		System.out.println();
		// 모든 switch 조건문 if - else if - else로 바꿀 수 있다.
		if(num == 1) {
			System.out.println("하나");
			System.out.println("ONE");
		} else if(num == 2) {
			System.out.println("둘");
			System.out.println("TWO");
		} else if(num == 3) {
			System.out.println("셋");
			System.out.println("THREE");
		} else {
			System.out.println("이도 저도 아님...");
		}
		// 스위치 보다는 거치는 과정이 많아서 속도가 느릴 수 있다.
		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class










