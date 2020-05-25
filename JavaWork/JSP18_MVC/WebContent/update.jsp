<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="com.lec.beans.*" %>  
<jsp:useBean id="dao" class= "com.lec.beans.WriteDAO"/>

<% //parameter 받아오기
	int uid = Integer.parseInt(request.getParameter("uid"));
	
%>

<%	//글을 담을 변수 선언 &초기화
	String name = "";
	String subject = "";
	String content = "";
	String regdate = "";
	int viewcnt = 0;
%>


		
		


<%-- 위 트랜잭션이 마무디 되면 되는 페이지 보여주기 --%>

<!DOCTYPE html>

<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>수정 <%= subject %></title>
</head>

<!-- 프론트 폼 검증 -->
<script>
	function chkSubmit() {
		frm = document.forms['frm'];
		var subject = frm['subject'].value.trim();
		
		if(subject == ""){
			alert("제목은 반드시 작성해야 합니다.");
			frm['subject'].focus();
			return false;
		}
		
		return ture;
	}
</script>



<body>
<h2>수정</h2>
<form name='frm' action='updateOk.do' method='post' onsubmit = 'return chkSubmit()'>
<input type='hidden' name='uid' value='<%= uid %>'/> <!-- ***post 방식으로  받은 값을 다시 내보내야 할때  ***-->

작성자 : <%= name %><br> <%-- 작성자 이름 변경불가 --%>
제목 : <input type="text" name="subject" value = "<%= subject %>" /><br>
내용: <br>
<textarea name='content'><%= content %></textarea>

<br>
<input type='submit' value='수정' />
</form>

<button onclick="history.back()">이전으로</button>
<button onclick="location.href ='list.do'">목록보기</button>

</body>
</html>


























