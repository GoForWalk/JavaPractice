<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="com.lec.beans.*" %>  

<%	// controller 에서 받아오기
	int cnt = (int)(request.getAttribute("DeleteResult"));
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
		location.href = "list.do";
	</script>
	
<% } %>



















