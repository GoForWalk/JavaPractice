package com.lec.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/*
	 * 
	 * 참고로, 
	 * 	일전에 JSP Model 에서
	 * 	Command 라 배웠던 객체를 'service 단' 이라고 한다.
	 * 
	 */
public interface Service {}



	class RegisterService implements Service{
		DAO dao;
		
		// 기본생성자는 없다

		public RegisterService(DAO dao) {
			System.out.println();
			this.dao = dao;
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return super.toString();
		}
		
	}
	
	class ReadService implements Service{
		DAO dao;
		
		// 기본생성자는 없다

		@Autowired
		// 매개변수 타입과 일치하는 빈 객체가 자동주입 된다.
		public ReadService() {
			this.dao = dao;
			System.out.println("readservice 작동");
		}
		
		
		@Override
		public String toString() {
			return super.toString();
		}
		
	}
	
	class UpdateService implements Service{
		// 멤버변수에 autowired 자동주입
		// 멤벼변수 '타입' 에 일치하는 bean 객체가 자동 주입된다.
		@Autowired
		DAO dao;
		
		// 기본생성자 있다.

		public UpdateService(DAO dao) {
			System.out.println("updateService() 생성");
			this.dao = dao;
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return String.format("[UpdateService : %s]", dao);
		}
		
	}
	
	class DeleteService implements Service{
		// 멤버변수에 autowired 자동주입
		// 멤벼변수 '타입' 에 일치하는 bean 객체가 자동 주입된다.
		DAO dao;
		
		// 기본생성자 있다.

		public DeleteService(DAO dao) {
			System.out.println("DeleteService() 생성");
			this.dao = dao;
		}
		
		// setter 에 @autowired 자동주입
		// setter 의 매개변수 '타입' 과 일치하는 bean 객체 
		
		@Autowired
		public void setDao(DAO dao) {
			System.out.printf("setDao(%s) 호출\n", dao.toString());
			this.dao = dao;
		}
		
		@Override
		public String toString() {
			return String.format("[DeleteService : %s]", dao.toString());
		}
	}

	
	class ListService implements Service{
		
		@Autowired
		@Qualifier("memberDAO")
		DAO memberDao;
		DAO boardDao;
		
		public ListService() {
			super();
			System.out.println(" listService() 생성");
		}

		@Autowired
		@Qualifier("BoardDAO")
		public final void setBoardDao(DAO boardDao) {
			this.boardDao = boardDao;
		}
		
		@Override
		public String toString() {
			return String.format("[ListService: %s, %s]", memberDao.toString(), boardDao.toString());
		
		}
	}
	
	class ViewService implements Service {
		
		@Autowired
		DAO myDao; // @Autowired 된 변수 이름 주목!

		public ViewService() {
			System.out.println("ViewService() 생성");
		}
		
		@Override
		public String toString() {
			return String.format("[ViewService: %s]", myDao.toString());
		}
				
		
	}
