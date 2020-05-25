<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:choose>
	<c:when test="${empty viewlist || fn: length(viewlist) == 0 }">
		<script>
			alert("해당정보가 삭제되거나 존재하지 않습니다..");
			history.back();
		</script>
	
	</c:when>	
	<c:otherwise>
		
<!DOCTYPE html>

<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>읽기 ${viewlist[0].subject }</title> <!-- title 에 글제목 넣기 -->
</head>

<script>
	function chkDelete(uid){
		// 삭제 여부, 다시확인하고 진행하기
		var r = confirm("삭제하시겠습니까?");
		
		if(r){
			location.href = "deleteOk.do";
		}
	}
</script>

<body>

UID : ${viewlist[0].uid }<br>
작성자 : ${viewlist[0].name }<br>
제목 : ${viewlist[0].subject }<br>
등록일 : ${viewlist[0].regDate }<br>
조회수 : ${viewlist[0].viewCnt }<br>

내용: <br>
<hr>
<div>
${viewlist[0].content }
</div>
<hr>
<br>
<button onclick="location.href = 'update.do?uid=${viewlist[0].uid }'">수정하기</button>
<button onclick="location.href = 'list.do'">목록보기</button>
<button onclick="chkDelete(${viewlist[0].uid })" >삭제하기</button>
<button onclick="location.href = 'write.do'">신규등록</button>

	
	</c:otherwise>
</c:choose>


</body>
</html>

























