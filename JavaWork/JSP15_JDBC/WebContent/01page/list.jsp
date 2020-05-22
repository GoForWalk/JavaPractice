<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%@ page import = "java.sql.*" %> <%-- JDBC 관련 import --%>
<%@ page import = "java.text.SimpleDateFormat" %> 

<%
	int curPage = 1; // 현재 페이지 (디폴트 1 page)
	
	// 현재 몇 페이지 인지 parameter 받아오기
	String pageParam = request.getParameter("page");
	
	// 검증: NN , 공백이 아니다.
	if(pageParam != null && !pageParam.trim().equals("")){
		try{
			//1 이상의 자연수
			int p = Integer.parseInt(pageParam);
			if(p > 0) curPage = p;
			
		} catch(NumberFormatException e){
			
		}
	}
	
	

%>


<%!
	// JDBC 관련 기본 객체변수
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null; // SELECT 결과, executeQuery()
	int cnt = 0; // DML 결과, executeUpdate()
	
	// Connection 에 필요한 세팅
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String userid = "scott0316";
	String userpw = "tiger0316";
%>

<%!
	// 쿼리문 준비
	//final String SQL_WRITE_SELECT = 
	//	"SELECT * FROM test_write ORDER BY wr_uid DESC" 	
	//;

	// 페이징
	// 글 전체의 목록 가져오기 
	final String SQL_WRITE_COUNT_ALL = "SELECT count(*) FROM test_write";

	// fromRow 부터 pageRows 만큼 SELECT
	// (몇번째) 부터 (몇개) 만큼!!
	final String SQL_WRITE_SELECT_FROM_ROW =  "SELECT * FROM " + 
			"(SELECT ROWNUM AS RNUM, T.* FROM (SELECT * FROM test_write ORDER BY wr_uid DESC) T) " + 
			"WHERE RNUM >= ? AND RNUM < ?";

	// 페이징 관련 세팅값들
	int writePages = 10;	// 한 [페이징]에 몇개의 '페이지' 를 표현할 것인가? 
	int pageRows = 8; 	// 한 페이지에 몇개의 글을 리스트 할 것 인가?
	int totalPage = 0; // 총 몇 '페이지' 분량인가?
	
	
%>

<%
	try{
		Class.forName(driver);
		out.println("드라이브 로딩 성공" + "<br>");
		conn = DriverManager.getConnection(url,userid,userpw);
		out.println("conn 성공" + "<br>");
		
		// 트렌잭션
		pstmt = conn.prepareStatement(SQL_WRITE_COUNT_ALL);
		
		rs = pstmt.executeQuery();
		
		if(rs.next())
			cnt = rs.getInt(1); // count(*), 전체 글의 갯수
			
		rs.close();
		pstmt.close();
		
		// 검색하고 한번 닫아! 
		
		totalPage = (int)Math.ceil(cnt / (double)pageRows); // 총 몇페이지 나오는지!! 
		
		int fromRow = (curPage - 1) * pageRows + 1; // 몇번째 row 부터 인지!!
		
		pstmt = conn.prepareStatement(SQL_WRITE_SELECT_FROM_ROW);
		pstmt.setInt(1, fromRow);
		pstmt.setInt(2, fromRow + pageRows);
		rs = pstmt.executeQuery();
		
		
%>


<!DOCTYPE html>

<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>글 목록 <%= curPage %></title>

<style>
	table {width: 100%}
	table, th, td {
		border: 1px solid black;
		border-collapse: collapse;
	}
</style>

<!-- 페이징 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="CSS/common.css"/>
<script src="https://kit.fontawesome.com/bb29575d31.js"></script>

</head>
<body>



		
<!-- table 의 목차 작성 -->
<hr>
<h2>리스트 <%= curPage %> 페이지</h2>
<h4><%= cnt %>개 </h4> <!-- 전체 글 개수 -->
<table>
	<tr>
		<th>row</th> <!-- row number -->
		<th>UID</th>
		<th>제목</th>
		<th>작성자</th>
		<th>조회수</th>
		<th>등록일</th>
	</tr>
			
		<%
		// 테이블 반복 생성 
		while(rs.next()){
			
			out.println("<tr>");
			
			// 변수 선언 & 초기화
			
			int rnum = rs.getInt("rnum");
			
			int uid = rs.getInt("wr_uid");
			String subject = rs.getString("wr_subject");
			String name = rs.getString("wr_name");
			int viewcnt = rs.getInt("wr_viewcnt");
			Date d = rs.getDate("wr_regdate");
			Time t = rs.getTime("wr_regdate");
			
			// 시간 생성 
			String regdate = "";
			if(d != null){
				regdate = new SimpleDateFormat("yyyy-MM-dd").format(d) + " " 
							+ new SimpleDateFormat("hh:mm:ss").format(t);
			}
			
			// table의  <td> value </td> 출력부 
			
			out.println("<td>" + rnum + "</td>");
			out.println("<td>" + uid + "</td>");
			out.println("<td><a href='view.jsp?uid=" + uid + "&page=" + curPage + "'>" + subject + "</a></td>");
			out.println("<td>" + name + "</td>");
			out.println("<td>" + viewcnt + "</td>");
			out.println("<td>" + regdate + "</td>");
			
			out.println("</tr>");
			
		}// end while
		
		%>	
		
		<!-- table 끝부분 -->	
		</table>
		<br>
		<button onclick="location.href='write.jsp'">신규등록</button>
		
		
		
		<%
		
		
	} catch(Exception e){
		e.printStackTrace();
		// 예외처리
	} finally {
		// 리소스 해제
		try{
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

%>

<%-- 위 트랜잭션이 마무디 되면 되는 페이지 보여주기 --%>

<%-- 페이징 --%>
<jsp:include page="pagination.jsp">
	<jsp:param value="<%= writePages %>" name="writePages"/>
	<jsp:param value="<%= totalPage %>" name="totalPage"/>
	<jsp:param value="<%= curPage %>" name="curPage"/>
</jsp:include>

</body>
</html>








