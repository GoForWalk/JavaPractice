package com.command.write;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.WriteDAO;

public class DeleteCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		WriteDAO dao = new WriteDAO();
		int cnt = 0;
		
		// 매개변수 받아오기
		int uid = Integer.parseInt(request.getParameter("uid"));
		
		try {
			
			cnt = dao.deleteByUid(uid);
			
			request.setAttribute("DeleteResult", cnt);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
