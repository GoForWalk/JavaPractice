<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

		
	<%
	// Controller 로 부터 결과 데이터 받음.
	int cnt = (Integer)request.getAttribute("result"); 
	// 트랜 잭션의 결과를 받은 request의 이름은 result
	%>

<%-- 위 트랜잭션이 마무디 되면 되는 페이지 보여주기 --%>

<% if(cnt == 0){ %>
	<script>
		alert("등록 실패!!!!");
		histroy.back(); // 브라우저가 기억하는 직전 페이지
	</script>
	
<% } else { %>
	<script>
		alert("등록 성공, 리스트를 출력합니다.");
		location.href ="list.do";
	</script>
	
	
<% } %>






