<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.lec.beans.*" %>    

<% // Controller 로 부터 결과 데이터 받아옴. 
	WriteDTO [] arr = (WriteDTO [])request.getAttribute("list"); // request 를 지칭하는 이름 잘 기억할 것! 
	
%>

<!DOCTYPE html>

<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>글 목록</title>

<style>
	table {width: 100%}
	table, th, td {
		border: 1px solid black;
		border-collapse: collapse;
	}
</style>

</head>
<body>

		
<!-- table 의 목차 작성 -->
<hr>
<h2>리스트</h2>
<table>
	<tr>
		<th>UID</th>
		<th>제목</th>
		<th>작성자</th>
		<th>조회수</th>
		<th>등록일</th>
	</tr>
		
	<%
		if(arr != null){
			for(int i = 0; i < arr.length; i++){
	%>							
		<tr>
			<td><%= arr[i].getUid() %></td>
			<td><a href ="view.do?uid=<%= arr[i].getUid()%>"><%= arr[i].getSubject() %></a></td>
			<td><%= arr[i].getName() %></td>
			<td><%= arr[i].getViewCnt() %></td>
			<td><%= arr[i].getRegDate() %></td>
		</tr>
				
	<% 			
			} // end for
		}// end if
	%>
		
		<!-- table 끝부분 -->	
		</table>
		<br>
		<button onclick="location.href='write.do'">신규등록</button>
		
		
<%-- 위 트랜잭션이 마무디 되면 되는 페이지 보여주기 --%>

</body>
</html>








