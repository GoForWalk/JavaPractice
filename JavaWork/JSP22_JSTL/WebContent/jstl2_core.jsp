<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>

<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>JSTL2_core</title>
</head>
<body>

<h2> set , remove, out</h2>

<c:set var="name" value="장윤성"/>

이름: <c:out value="jang"/><br>
이름: <c:out value='${name }'/><br> <%-- JSTL 변수는 EL 에서 사용가능 - 서버쪽에서 생성된 변수: name --%>
${name }<br>						

<c:remove var="name"/> <%-- 변수 제거 --%>
이름: <c:out value='${name }'/><br>



<hr>

<%
	int age = 10;
%>

나이: ${age }<br> <%-- java 변수는 EL에서 사용할 수 없다. --%>

<c:set var="age" value="<%=age %>"/>
나이: ${age }<br> <%-- set 으로 자바의 변수를 서버 변수로 옮겨주면 EL로 사용 가능 --%>


<hr>
<h2>catch</h2>

<c:catch var="error">
<!-- 이 안에서 예외 발생하면, 예외객체를 error 변수에 담는다. -->
	<%= 2 / 0 %>
</c:catch>
<br>
<c:out value="${error }"/> <!-- exception 이름, 내용 -->

<br>

<c:catch var="ex">
name parameter 값 = <%= request.getParameter("name") %><br> <!-- null -->


<!-- nullpointException 발생시키기 -->
<% if(request.getParameter("name").equals("test")){ %>
	
	${param.name } 은 test 입니다.

<% } %>

</c:catch>



<c:if test="${ex != null }">
	예외발생<br>
	${ex }<br>
</c:if>

































</body>
</html>