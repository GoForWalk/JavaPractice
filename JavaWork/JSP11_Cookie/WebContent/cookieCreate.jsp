<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*" import="java.text.*" %>

    
<%
	String cookieName1 = "num1";
	String cookieValue1 = "" + (int)(Math.random() * 10);
	Cookie cookie1 = new Cookie(cookieName1, cookieValue1); // 이름 - 값 으로 쿠키 생성
	cookie1.setMaxAge(2 * 30); // 쿠키 파기시간 : 초 단위 (생성시점으로 2 * 30초 후);
	response.addCookie(cookie1); // 생성된 쿠키를 response 에 쿠키 정보 추가
	
	String cookieName2 = "datetime";
	String cookieValue2 = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()); // 쿠키의 날짜포멧은 "yyyyMMddHHmmss"
	Cookie cookie2 = new Cookie(cookieName2, cookieValue2);
	cookie2.setMaxAge(30);
	response.addCookie(cookie2);
	
	
%>

<script>
alert("<%= cookieName1%> 쿠키생성");
location.href = "cookieList.jsp";

</script>