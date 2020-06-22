package com.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.CategoryDAO;
import com.lec.beans.CategotyDTO;

import javafx.scene.DepthTest;

public class CateListCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		CategoryDAO dao = new CategoryDAO();
		CategotyDTO [] cateArr = null;
		int count = 0;
		
		StringBuffer message = new StringBuffer();
		String status = "FAIL"; // default = fail
		
		int depth = 1;
		int parent = 0;
		
		String param1 = request.getParameter("depth");
		String param2 = request.getParameter("parent");
		
				
		
		if(param2 == null && param1 == null) {
		 
			depth = 1;
			parent = 0;
		  
		} else if(param1 == null ) {
			
			depth = Integer.parseInt(param1);
			parent = Integer.parseInt(param2);
			
		} else if(param2 == null || param2 == "" ) {
			
			depth = Integer.parseInt(param1);
			parent = Integer.parseInt(param2);
		} 
		
		try {
			
			if(depth != 1 && depth != 2 && depth != 3) { // depth 값이 일치하지 않을 때
				
				message.append("바람직하지 않은 depth 값 입니다.");
				
			} else {
				
				cateArr = dao.selectByDepthParent(depth, parent);
				
				if(cateArr == null) {
					
					message.append("0개의 데이터");
					
				} else {
					
					status = "OK";
					count = cateArr.length; 
					
				}
			}
			
		} catch (SQLException e) {
			message.append("트랜잭션 에러 : " + e.getMessage());
		} catch (Exception e ) {
			message.append("예외발생 : " + e.getMessage());
		}
		
		request.setAttribute("count", count);
		request.setAttribute("status", status);
		request.setAttribute("message", message);
		request.setAttribute("data", cateArr);
		
	}

}
