<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%	// parameter 받아오기
	request.setCharacterEncoding("utf-8");
%>

<c:choose>
	<c:when test="${empty update }">
		<script>
			alert('수정실패');
			histroy.back();
		</script>
	</c:when>
	<c:otherwise>
		<script>
			alert('수정성공');
			location.href = "view.do";
		</script>
	</c:otherwise>
</c:choose>




















