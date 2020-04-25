package com.lec.java.collection04;

import java.util.ArrayList;
import java.util.Scanner;

public class Collection04Main {

	public static void main(String[] args) {
		System.out.println("ArrayList 연습");

		// TODO
		ArrayList<MemberModel> memberList = new ArrayList<MemberModel>();
		
		MemberModel memberModel;
		
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < 3; i++) {
			
		
		System.out.println("id를 입력하세요");
		String id = sc.nextLine();
		System.out.println("pw를 입력하세요");
		String pw = sc.nextLine();
		
		memberList.add(new MemberModel(id, pw));
		
		}
		
		sc.close();
		System.out.println("-----------출 력-------------");
		
		for (int j = 0; j < 3; j++) {
			
			System.out.println(memberList.get(j));
		}
		
//		Iterator<MemberModel> itr = MemberList.iterator();
//		while(itr.hasNext()) {
//			itr.next().displayInfo();
//		}
		
		System.out.println("---------------------------");
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class












