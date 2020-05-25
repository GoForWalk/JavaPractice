<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="com.lec.beans.*" %>  
<jsp:useBean id="dao" class= "com.lec.beans.WriteDAO"/>

<% //parameter 받아오기
	int uid = Integer.parseInt(request.getParameter("uid"));
	// *** 이 단계에서 parameter 검증 필요 ***
	
	// uid 값 반드시 필요 -> uid 가 없으면~ return
	
	// 검증 단계에서 return 사용!!
%>

<%
//DAO 사용한 트랜잭션
	WriteDTO [] arr = dao.selectByUid(uid);

%>


<%	//글을 담을 변수 선언 &초기화
	String name = "";
	String subject = "";
	String content = "";
	String regdate = "";
	int viewcnt = 0;
%>

		<script>
			alert("해당정보가 삭제되거나 존재하지 않습니다..");
			history.back();
		</script>
		


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
<form name='frm' action='updateOk.jsp' method='post' onsubmit = 'return chkSubmit()'>
<input type='hidden' name='uid' value='<%= uid %>'/> <!-- ***post 방식으로  받은 값을 다시 내보내야 할때  ***-->

작성자 : <%= name %><br> <%-- 작성자 이름 변경불가 --%>
제목 : <input type="text" name="subject" value = "<%= subject %>" /><br>
내용: <br>
<textarea name='content'><%= content %></textarea>

<br>
<input type='submit' value='수정' />
</form>

<button onclick="history.back()">이전으로</button>
<button onclick="location.href ='list.jsp'">목록보기</button>

</body>
</html>


























