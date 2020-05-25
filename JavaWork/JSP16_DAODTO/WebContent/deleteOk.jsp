<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:useBean id="dao" class= "com.lec.beans.WriteDAO"/>
<%@ page import="com.lec.beans.*" %>  

<%	// parameter 받아오기
	int uid = Integer.parseInt(request.getParameter("uid"));
	
	// ** 이단계 에서 parameter 검증 필요
%>

<%
	int cnt = dao.deleteByUid(uid);
%>

<%-- 위 트랜잭션이 마무리 되면 되는 페이지 보여주기 --%>
<% if(cnt == 0){ %>

	<script>
		alert('삭제 실패');
		histroy.back();
	</script>
	
<% } else { %>

	<script>
		alert('삭제 성공');
		location.href = "list.jsp";
	</script>
	
<% } %>



















