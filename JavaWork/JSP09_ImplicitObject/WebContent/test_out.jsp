<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>out</title>
</head>
<body>

<%--
<%
	int i = 0; 
	for(;;){
		i++;
		out.println("5 * " + i + " = " +  5 * i + "<br>");	
%>
	------------ <br>		
<%
		if(i >= 9) break;
	}
%>
--%>


<%! // <- 선언부 태그 : 변수 선언, 메소드 정의
	int i = 100;
	String str = "test";
	
	public int hap(int a, int b){
		return a + b;
	}
	
%>

<% // 스크립트릿
	out.print("i = " + i + "<br>");
	out.print("str = " + str + "<br>");
	out.print("hap = " + hap(2,10) + "<br>");
	
%>
<br><hr><br>

i = <%= i %><br>
str = <%= str %><br>
hap = <%= hap(2,10) %><br>


</body>
</html>