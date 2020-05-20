<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%! 
    public static final String ADMIN_ID = "admin";
    public static final String ADMIN_PW = "1234";
    %>
    
    <%
    String userid = request.getParameter("userid");
    String pw = request.getParameter("pw");
    
    String cookieName = "userid";
    String cookieValue = userid;
    
    // userid / pw 일치하면 로그인 성공  +  쿠키 생성!
    if(ADMIN_ID.equalsIgnoreCase(userid) && ADMIN_PW.equals(pw)){
    	out.println("<script>");
    	out.println("alert('로그인 성공!!')");
    	out.println("</script>"); // 로그인 성공시 팝업 띄우기
    	
    	// 쿠키 발행
    	Cookie cookie = new Cookie(cookieName, cookieValue);
    	cookie.setMaxAge(2 * 30);
    	response.addCookie(cookie);
    	
     	// 로그인 상태에서 60초간 request 없으면 쿠키 삭제와 동시에 로그인 해지
    	
    } else {
    	out.println("<script>");
    	out.println("alert('로그인 실패!!')");
    	out.println("</script>");
    	
    	// 로그인 실패시 쿠키 제거
    	Cookie cookie = new Cookie(cookieName, cookieValue);
    	cookie.setMaxAge(0); // 기존에 있더라도 삭제한다.
    	response.addCookie(cookie);
    }
    
    %>
    
    <script>
    location.href = "login.jsp";
    </script>
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    