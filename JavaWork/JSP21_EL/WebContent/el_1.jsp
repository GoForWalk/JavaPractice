<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
</head>


<body>
<h3>Expression Language</h3>
${10}<br>
${99.99}<br>
${"ABC" }<br>
${true }<br>


<hr>
<h3>EL 의 연산자</h3>
${1+2 }<br>
${1-2 }<br>
${1*2 }<br>
${1/2 }<br>
${1>2 }<br>
${1<2 }<br>
${(1<2)? 1: 2 }<br>
${(1<2) || (1>2) }<br>

<%
	int num = 10;
%>

num: ${num} <br> <%-- EL은 Java언어가 아니다. Java 변수 그대로 표현은 안됨 // 오류가 있어도 에러가 뜨지 않는다. --%>



</body>
</html>




















