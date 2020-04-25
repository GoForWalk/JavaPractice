package com.lec.java.collection09;

import java.util.Iterator;
import java.util.TreeSet;

/* TreeSet // 1. 중복된 자료는 안들어 간다.  2. 순서는 정해지지 않는다.

 Collection<E>
  |__ Set<E>
       |__ HashSet<E>, TreeSet<E> // Tree~~~ : 정렬 상태!!

 TreeSet: 데이터가 정렬된 상태로 저장(오름차순, 내림차순)
 
 	(※ TreeXXX ← 주로 '정렬'에 특화된 자료구조 입니다)
*/
public class Collection09Main {

	public static void main(String[] args) {
		System.out.println("TreeSet 클래스");
		
		// Integer 타입을 저장할 수 있는 TreeSet 인스턴스 생성
		TreeSet<Integer> tset = new TreeSet<Integer>();
		
		tset.add(11);
		tset.add(2);
		tset.add(14);
		tset.add(1);
		tset.add(7);
		tset.add(15);
		tset.add(5);
		tset.add(8);
		
		// 데이터 검색 - Iterator 사용
		// TreeSet인 경우에 iterator() 메소드 오름차순 정렬
		System.out.println("	오름차순:");
		Iterator<Integer> itr = tset.iterator(); 
		while(itr.hasNext()) {
			System.out.println("	" + itr.next());
		}
		
		
		System.out.println();
		System.out.println("	내림차순:");
		// 내림차순 Iterator : descendingIterator() 사용
		Iterator<Integer> itr2 = tset.descendingIterator();
		while(itr2.hasNext()) {
			System.out.println("	" + itr2.next());
		}
		
		// enhanced for
		System.out.println();
		System.out.println("enhanced for");
		for(Integer i : tset) {
			System.out.println(i);
		}
		
		// subset() 메소드
		// 시작값과 끝값을 매개변수로 받아, 그것을 범위로, 부분 set 추출
		System.out.println();
		System.out.println("subSet()");
		TreeSet<Integer> subset = (TreeSet<Integer>)tset.subSet(5, 14); // 5~ 14 데이터 전까지 (14는 출력 X)
//		for(Integer e : subset) {
//			System.out.println(e);
//		}
		
		System.out.println(subset); // subSet() 의 toString은 overriding 되어 있다.
		
		subset = (TreeSet<Integer>)tset.subSet(3, 10); // 동작한다!!!  (3 <= ㅑ < 10 )
		System.out.println(subset); 
		// 대소 비교 가능!!!
		
		subset = (TreeSet<Integer>)tset.subSet(5, true, 14, true); // 5 포함, 14 포함!! 
		System.out.println(subset); 
		
		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class












