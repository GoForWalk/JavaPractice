<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="cnt" class="com.lec.beans.CountBean" scope="page"/>

<b>cnt의 getCount 호출</b><br>

<jsp:getProperty property="count" name="cnt"/><br>

<a href="scope1_page1.jsp">page1로...</a>