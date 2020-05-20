<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%! 
    public static final String ADMIN_ID = "admin";
    public static final String ADMIN_PW = "1234";
    %>
    
    <%
    String userid = request.getParameter("userid");
    String pw = request.getParameter("pw");
    
    String sessionName = "userid";
    String sessionValue = userid;
    
 // userid / pw 일치하면 로그인 성공  +  쿠키 생성!
    if(ADMIN_ID.equalsIgnoreCase(userid) && ADMIN_PW.equals(pw)){
    	out.println("<script>");
    	out.println("alert('로그인 성공!!')");
    	out.println("</script>"); // 로그인 성공시 팝업 띄우기
    	
    	// 세션 발행
    	session.setAttribute(sessionName, sessionValue);
    	
    } else {
    	out.println("<script>");
    	out.println("alert('로그인 실패!!')");
    	out.println("</script>");
    	
    	// 로그인 실패시 쿠키 제거
    	session.removeAttribute(sessionName);
    }
    
    
    %>
    
    <script>
    location.href = "login.jsp";
    </script>
    
    