<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*" %> <%-- JDBC 관련 import --%>

<%
	// 해당 jsp 문서에 필요한 import 받아오기
	// TODO 
%>

<%
	// parameter 받아오기 전 한글로 인코딩!! 
	// request.setCharacterEncoding("utf-8"); // 한글 인코딩 꼭!! 
	
	// parameter 받아오기 (변수 선언 = request.getParameter("name"))
	// TODO
	
	// parameter 받아온 뒤, 해당 data에 대한 form 검증
	// TODO
	
	// 검증 과정에서 부합하지 않는 조건을 찾은 뒤, return 시킨다. 
	// 조건문 사이에 <script> alert을 사용하여 팝업창으로 알려주기!! 가능
	
	// return 의 의미:
		// 더 이상 JSP 프로세싱 하지 않도록 종료!!!! <-- 중요!!!!  
		// JSP 안에서 리턴은 더이상 아래 부분을 프로세싱 하지 않는다.
%>



<%!
	// JDBC 관련 기본 객체변수
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null; // SELECT 결과, executeQuery()
	int cnt = 0; // DML 결과, executeUpdate()
	
	// Connection 에 필요한 세팅
	final String DRIVER= "oracle.jdbc.driver.OracleDriver";
	final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	final String USERID = "scott0316";
	final String USERPW = "tiger0316";
%>

<%!
	// 쿼리문 준비
	
	// TODO

%>

<%
	try{
		Class.forName(DRIVER);
		out.println("드라이브 로딩 성공" + "<br>");
		conn = DriverManager.getConnection(URL,USERID,USERPW);
		out.println("conn 성공" + "<br>");
		
		// 트렌잭션 실행
		
		// TODO
		
	} catch(Exception e){
		e.printStackTrace();
		// 예외처리
		
		// 개발 과정에서 error 메세지를 열람하고자 하면,
		// throw e;
		// 를 통해 서버에서 발생하는 error 창 확인 가능
		
		// 트렌잭션 수행 중 문제 발생하여, 쿼리 롤백해야하는 경우
		// 여기서 rollback
		
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

<%-- 위 트랜잭션이 마무리 되면 되는 페이지 보여주기 --%>
<!-- view 단 작성 -->


