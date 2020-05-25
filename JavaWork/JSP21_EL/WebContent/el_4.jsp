<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.lec.beans.WriteDTO" %>
<!DOCTYPE html>

<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>EL request</title>
</head>
<body>
<%
	request.setAttribute("myage", 30);
	request.setAttribute("mydto", new WriteDTO(100, "제목", "내용", "작성자", 3));
	pageContext.setAttribute("myage", "흠!!");
%>

<%-- scope 우선순위!! : 1. page > request > session > application --%>

${myage }<br> <%-- 우선순위 때문에, 의도와 다른 결과가 나올 수 있다. --%>
${requestScope.myage }<br> <%-- Scope를 구체적으로 명시한다. --%>

${mydto} <br> <%-- toString() 값 --%>
${mydto.uid }<br>

<%= ((WriteDTO)request.getAttribute("mydto")).getUid() %><br>
${mydto.subject }<br>
${mydto.content }<br>

</body>
</html>