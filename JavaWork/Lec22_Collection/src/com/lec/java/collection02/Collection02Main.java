package com.lec.java.collection02;

import java.util.ArrayList;
import java.util.Iterator;

public class Collection02Main {

	public static void main(String[] args) {
		System.out.println("ArrayList 연습");
		//TODO:
		// String 타입을 담는 ArrayList를 만들고
		// 5개 이상의 String을 저장하고
		// set(), remove() 등의 메소드 사용하여
		// 임의의 것을 수정, 삭제 도 해보시고
		// 3가지 방식으로 출력해보세요
		//  for, Enhanced-for, Iterator
		
		ArrayList<String> list = new ArrayList<String>();

		list.add("aaa"); // 자료 추가
		list.add("bbb");
		list.add("ccc");
		list.add("ddd");
		list.add("eee");
		list.add("fff");
		System.out.println("출력");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	
		list.set(2, "zzz"); // 3번째 자료 수정
		System.out.println();
		System.out.println("수정 후 출력");
		
		for(String s : list) {
			System.out.println(s);
		}
		
		list.remove(1); // 2번째 자료 삭제
		
		System.out.println();
		System.out.println("삭제 후 출력");
		
		Iterator<String> itr = list.iterator(); // Iterator 를 사용한 출력
		while(itr.hasNext()) { // hasNext : boolean type
			System.out.println(itr.next());
		}
		
		
		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class












