package com.command.write;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.WriteDAO;
import com.lec.beans.WriteDTO;
import com.sun.corba.se.impl.ior.WireObjectKeyTemplate;

public class ListCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		WriteDAO dao = new WriteDAO(); // DAO 객체 생성
		WriteDTO [] arr = null;
		
		try {
			// 트랜잭션 수행
			arr = dao.select();
			
			// "list" 란 name 으로 request 에 arr 값 전달
			// 즉 request 에 담아서, 컨트롤러에 전달되는 셈.
			request.setAttribute("list", arr); // list 이름 반드시 기억한다!!! list 바구니에 자료를 담는다.
			
			
		} catch (SQLException e) {
			// 만약 CP 사용한다면,
			// NamingException 도 처리해야 함.
			
			e.printStackTrace();
		}
		
	}

}
