package com.lec.java.access03;

import com.lec.java.access04.Testpublic2;

//import com.lec.java.access04.MyDefault2; 	// err: is not visible 
											//(다른 패키지의 default 클래스는 import 단계에서 오류가 발생한다.)
//import com.lec.java.access04.Testpublic; 	

// 클래스의 접근 권한 수식어: public, (default)
// 1. public class: 어디에서나 인스턴스 생성이 가능한 클래스
//   (주의) public 클래스의 이름은 .java 파일 이름과 반드시 같아야 함
// 2. (default) class: 같은 패키지에 있는 클래스들에서만 인스턴스 생성이 가능

public class Access03Main {

	public static void main(String[] args) {
		System.out.println("public, default 클래스");
		
		TestPublic t1 = new TestPublic(); // 디폴트 생성자(Java에서 자동제공)
		
		// 같은 패키지에 있는 클래스는 인스턴스 생성(사용) 가능
		MyDefault t2 = new MyDefault(); 

		//다른패키지에 있는 public 클래스 - import 해야한다!!!
		// ==> 인스턴스 생성 가능!
		Testpublic2 t3 = new Testpublic2();
		
		
		//다른 패키지에 있는 default class
		// --> 인스턴스 생성 가능? (ㄴㄴ!!) 안댐
//		MyDefault2 t4;
		
		// 다른 패키지의 클래스와 동일 이름의 클래스가 충돌한다면? - 패키지 주소부터 모두 찍어준다.
		com.lec.java.access04.Testpublic t11 = 
				new com.lec.java.access04.Testpublic();
		
		
	} // end main()

} // end class Access05Main










