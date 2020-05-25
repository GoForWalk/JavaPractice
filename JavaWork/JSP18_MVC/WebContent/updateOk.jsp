<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="com.lec.beans.*" %>  

<%	// parameter 받아오기
	request.setCharacterEncoding("utf-8");
%>

<% // controller 에서 결과 데이터 받아옴
	int cnt = (Integer)request.getAttribute("update");
	

%>

<%-- 위 트랜잭션이 마무리 되면 되는 페이지 보여주기 --%>
<% if(cnt == 0){ %>

	<script>
		alert('수정실패');
		histroy.back();
	</script>
	
<% } else { %>

	<script>
		alert('수정성공');
		location.href = "view.do";
	</script>
	
<% } %>



















