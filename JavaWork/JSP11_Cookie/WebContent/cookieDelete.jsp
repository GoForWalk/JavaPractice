<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <%
 
 Cookie[] cookies = request.getCookies();
 String cookieName = "num1";
 
 if(cookies != null){
	 for(int i = 0; i <cookies.length; i++){
		 if(cookieName.equals(cookies[i].getName())){ // 클라이언트 보고 삭제하라고 해야한다.
			 cookies[i].setMaxAge(0); // response 되자마자 쿠키들의 생존시간을 0 으로 변경 -> 쿠키 바로 사라진다.
			 response.addCookie(cookies[i]);
		 }
			 
	 }
 }
 
 %>
 
 <script>
 	alert("<%= cookieName %> 쿠키 삭제");
 	location.href = "cookieList.jsp";
 
 </script>