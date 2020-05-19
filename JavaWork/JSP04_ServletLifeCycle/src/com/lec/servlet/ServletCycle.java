package com.lec.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Cycle")
public class ServletCycle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	// 서블릿 생성자, 첫 request 발생시 최초 단 한번 생성된다.
    public ServletCycle() {
        super();
        System.out.println("서블릿 생성");
    }
    
    // init() override : 서블릿 객체 생성 이후(직후) 호출된다.
    // 생성할 때 필요한 자원 불러올때 사용하여 override 시킨다.
    @Override
    public void init() throws ServletException {
    	super.init();
    	System.out.println("init() 호출");
    	// 최초에 단한번 생성
    }
    
    
    @Override
    public void destroy() { // 서블릿 객체 소멸된때 생성 : 서버가 종료 될 때!! 
    	super.destroy();
    	System.out.println("destroy() 호출");
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet 호출");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost 호출");
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("service() 호출"); // doGet 이나 doPost 보다 먼저 수행 된다!! 
	}
}























