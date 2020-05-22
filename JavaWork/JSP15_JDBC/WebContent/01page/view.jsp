<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import = "java.sql.*" %> <%-- JDBC 관련 import --%>
<%@ page import = "java.text.SimpleDateFormat" %> 

<% 	//parameter 받아오기
	int uid = Integer.parseInt(request.getParameter("uid"));
	String pageParam = request.getParameter("page");
	// *** 이 단계에서 parameter 검증 필요 ***
	
	// uid 값 반드시 필요 -> uid 가 없으면~ return
	
	// 검증 단계에서 return 사용!!
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
 	final String SQL_WRITE_INC_VIEWCNT = 
 		"UPDATE test_write SET wr_viewcnt = wr_viewcnt + 1 WHERE wr_uid = ?";

	final String SQL_WRITE_SELECT_BY_UID = 
			"SELECT * FROM test_write WHERE wr_uid = ? ";
%>

<%	//글을 담을 변수 선언 &초기화
	String name = "";
	String subject = "";
	String content = "";
	String regdate = "";
	int viewcnt = 0;
%>



<%
	try{
		Class.forName(driver);
		out.println("드라이브 로딩 성공" + "<br>");
		conn = DriverManager.getConnection(url,userid,userpw);
		out.println("conn 성공" + "<br>");
		
		// 트렌지션 실행 <transition>
		// Auto-commit 비활성화 <transition1>
		conn.setAutoCommit(false);
		
		// 쿼리들 수행
		pstmt = conn.prepareStatement(SQL_WRITE_INC_VIEWCNT);
		pstmt.setInt(1, uid);
		cnt = pstmt.executeUpdate();
		
		pstmt.close();
		
		pstmt = conn.prepareStatement(SQL_WRITE_SELECT_BY_UID);
		pstmt.setInt(1, uid);
		rs = pstmt.executeQuery();
		
		// 최대 하나의 레코드만 select 된다 -> 반복문 안써도 된다
		
		if(rs.next()){
			subject = rs.getString("wr_subject");
			content = rs.getString("wr_content");
			
			if(content == null) content = "";  // null 처리  (본문은 null 가능 / 제목은 not null)
			
			name = rs.getString("wr_name");
			viewcnt = rs.getInt("wr_viewcnt");
			Date d = rs.getDate("wr_regdate");
			Time t = rs.getTime("wr_regdate");
			
			regdate = "";
			if(d != null){
				regdate = new SimpleDateFormat("yyyy-MM-dd").format(d) + " " 
							+ new SimpleDateFormat("hh:mm:ss").format(t);
			}
			
		} else {
			// query는 성공했는데 레코드가 없다
			// wr_uid 값의 레코드가 없는 뜻
%>
		<script>
			alert("해당정보가 삭제되거나 존재하지 않습니다..");
			history.back();
		</script>
		
<%		
			return; // 더
		} //end if
		
		
		
		// 모든 쿼리 성공하면 commit <transition2>
		conn.commit();
		
	} catch(Exception e){
		e.printStackTrace();
		// 예외처리
		
		conn.rollback(); // 쿼리  실패하면 롤백!! <transition3>
		
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

<!DOCTYPE html>

<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>읽기 <%= subject %></title> <!-- title 에 글제목 넣기 -->
</head>

<script>
	function chkDelete(uid){
		// 삭제 여부, 다시확인하고 진행하기
		var r = confirm("삭제하시겠습니까?");
		
		if(r){
			location.href = 'deleteOk.jsp?uid=' + uid + '&page=' + <%=pageParam%>;
			
		}
	}
</script>

<body>

UID : <%= uid %><br>
작성자 : <%= name %><br>
제목 : <%= subject %><br>
등록일 : <%= regdate %><br>
조회수 : <%= viewcnt %><br>

내용: <br>
<hr>
<div>
<%= content %>
</div>
<hr>
<br>
<button onclick="location.href = 'update.jsp?uid=<%= uid%>'">수정하기</button>
<button onclick="location.href = 'list.jsp'">목록보기</button>
<button onclick="chkDelete(<%=uid %>)" >삭제하기</button>
<button onclick="location.href = 'write.jsp'">신규등록</button>



</body>
</html>

























