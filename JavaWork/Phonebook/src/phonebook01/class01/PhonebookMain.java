package phonebook01.class01;

import java.util.Scanner;

public class PhonebookMain {
	
	Scanner sc;
	PhonebookModel [] bookData = new PhonebookModel[5];
	
	public static void main(String[] args) {
		PhonebookMain app = new PhonebookMain();
		app.init(); 	//초기화
		app.run();		// 실행
		app.exit();		// 종료
		
	} // main() end
	
	
	// 응용프로그램을 초기화
	 public void init() {
		 sc = new Scanner(System.in);
	 }
	 
	// 응용프로그램 구동
	public void run() {
		System.out.println("전화번호부 ver1.0");
		
		while(true) {
			showMenu(); // 메뉴 표시
			
			int menu = sc.nextInt(); 	// 메뉴 입력
			sc.nextLine(); // 버퍼 비우기
			
			switch (menu) {
			case 1:
				System.out.println("전화번호부를 입력합니다.");
				insertPhoneBook();
				
				break;
			case 2:
				System.out.println("전화번호부를 출력(열람)");
				showPhoneBook();
				
				break;
			case 3:
				System.out.println("프로그램을 종료합니다.");
				return;
			default: 
				System.out.println("잘못입력 하셨습니다.");
				break;
			}
			
		}// end while
	}// end run()
	
	// 응용프로그램 종료
	public void exit() {
		sc.close();
	} // end exit
	
	//전화번호부 입력
	public void insertPhoneBook() {
		//TODO
		// 전화번호부가 다 찻는지 체크
		int i;
		for(i = 0; i < bookData.length; i++) {
			if(bookData[i] == null) break;
		}
		
		if(i == bookData.length) {
			System.out.println("전화번호부가 다 찼습니다.");
			return;
		}
		// 다 찼으면, 입력불가처리
		System.out.println("이름 입력");
		String name = sc.nextLine();
		
		System.out.println("전화번호 입력");
		String phoneNum = sc.nextLine();
		
		System.out.println("이메일 입력");
		String email = sc.nextLine();
		
		// 이름, 전화번호, 이메일 입력을 받으세요
		// --> PhonebookModel 인스턴스 생성
		
		PhonebookModel pb = new PhonebookModel(name, phoneNum, email);
		pb.setUid(i);
		
		//배열에 추가
		bookData[i] = pb;
		System.out.println((i+1) + "번째 전화번호부 추가 성공");
		
		}
	
	//전화번호부 출력
	public void showPhoneBook() {
		
		int i;
		for (i = 0; i < bookData.length; i++) {
			PhonebookModel pb = bookData[i];
			if (pb == null) {
				break;
			}
			System.out.println(pb);
		}
		System.out.println(i + " 개의 전화번호부 출력");
		
		//배열 안에 전화번호부 출력
	}
	
	public void showMenu() {
		System.out.println();
		System.out.println("전화번호부 프로그램");
		System.out.println("------------------");
		System.out.println("[1] 입력");
		System.out.println("[2] 열람");
		System.out.println("[3] 종료");
		System.out.println("------------------");
		System.out.print("선택: ");
	}
	
} //end class
