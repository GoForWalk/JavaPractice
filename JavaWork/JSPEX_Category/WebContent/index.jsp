<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/CSS/common.css"/>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="${pageContext.request.contextPath }/JS/category.js"></script>
<title>다단계 카테고리 - SELECT 하기</title>
</head>
<body>

<!-- 여기부터  -->
<div class="cate" id="mycate">
	<span>
		<select id="select1" disabled></select>
	</span>
	<span>
		<select id="select2" disabled></select>
	</span>
	<span>
		<select id="select3" disabled></select>
	</span>
</div>
<!-- 여기까지 안건드려도 됨 -->

</body>
</html>