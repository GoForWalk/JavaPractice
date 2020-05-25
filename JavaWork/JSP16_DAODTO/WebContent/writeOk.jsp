<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:useBean id="dao" class="com.lec.beans.WriteDAO" /> <%-- DAO bean --%>

<%
	request.setCharacterEncoding("utf-8"); // 한글 인코딩 꼭!! 
%>
<jsp:useBean id="dto" class="com.lec.beans.WriteDTO"/>
<jsp:setProperty property="*" name="dto"/> 
<!-- value 가 빠져있다!! -> for 문으로 가져오는 데이터 값을 모두 일치시킨다. -->

<%-- 
<%
	request.setCharacterEncoding("utf-8"); // 한글 인코딩 꼭!! 	
	// 입력한 값 받아오기
	String name = request.getParameter("name"); // parameter 잘 넘어오는지 bp
	String subject = request.getParameter("subject");
	String content = request.getParameter("content");
	
	// 백엔드 검증 (서버 단 검증)
	// 유효성 체크
	// name, subject = not null
	// null 이거나 빈 문자열이면 이전화면으로 돌아가기
	
	if(name == null || subject == null ||
		name.trim().equals("") || subject.trim().equals("")){
	%>
	
	<script>
		alert("작성자 이름, 글제목은 필수입니다!");
		history.back(); // history.go(-1);
	</script>
	
	<%
			return; // 더 이상 JSP 프로세싱 하지 않도록 종료!!!! <-- 중요!!!!  
					// JSP 안에서 리턴은 더이상 아래 부분을 프로세싱 하지 않는다.
					
		} %> --%>
		
	<%
	// DAO 사용한 트랜잭션
	//int cnt = dao.insert(subject, content, name);
	
	int cnt = dao.insert(dto);
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
		location.href ="list.jsp";
	</script>
	
	
<% } %>






