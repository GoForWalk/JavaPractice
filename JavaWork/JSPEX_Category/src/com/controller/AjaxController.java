package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.command.AjaxListCommand;
import com.command.AjaxResultCommand;
import com.command.CateListCommand;

@WebServlet("*.ajax")
public class AjaxController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AjaxController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);

	}

	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// TODO
		request.setCharacterEncoding("UTF-8");
		
		// /cate_list.ajax : 목록 요청
	
		String uri = request.getRequestURI();
		String contextpath = request.getContextPath();
		String com = uri.substring(contextpath.length());
		
		switch (com) {
		case "/category.ajax":
			new CateListCommand().execute(request, response);
			new AjaxListCommand().execute(request, response);
			break;

		default:
			break;
		}
		
		
	}
	
	
	
	
	
}
