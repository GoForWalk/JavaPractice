<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%-- page 지시자를 태그를 사용한 예외처리 --%>
<%@ page errorPage="error.jsp" %>

<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>예외발생1 </title>
</head>
<body>

<%= request.getParameter("id").toUpperCase() %>




</body>
</html>