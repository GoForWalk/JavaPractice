package com.lec.java.db03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lec.java.db.Query;


// 공통적으로 사용하는 상수들 인터페이스에 담아서 처리.

public class DB03Main implements Query{

	public static void main(String[] args) {
		System.out.println("DB 3 - PreparedStatement");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			// OracleDriver 클래스를 메모리에 로딩
			Class.forName(DRIVER);
			System.out.println("드라이버 클래스 로딩 성공");
			
			// DB Connection
			conn = DriverManager.getConnection(URL, USER, PASSWD);
			System.out.println("DB Connection 성공");
			
			pstmt = conn.prepareStatement(SQL_INSERT);
			//"INSERT INTO " + TBL_NAME + " VALUES(?, ?, ?)";
			
			
			pstmt.setInt(1, 10); // 첫번째 ? 는 1부터 시작 (rowindex), 두번째 ? 는 value!!
			pstmt.setString(2, "헐크");
			pstmt.setString(3, "2020-10-10");
			
			int cnt = pstmt.executeUpdate(); // DML 멍령어 -> 정수값 리턴!!!!
			System.out.println(cnt + "개 행(row) INSERT 성공!!");
			
			// UPDATE
			System.out.println();
			System.out.println("UPDATE");
			pstmt.close(); // 이전의 pstmt 를 닫아야 다음 자료를 넣을 수 있다.
			// 사실, pstmt 를 여러번 클로즈하고 여는것은 서버에 로딩이 걸리기 때문에, 좋은 방법은 아니다.
			// 쿼리문 여러개를 만들때는 prepareStatment 문에 대한 선언을 따로 해주는게 더 바람직 하다.
			
			pstmt = conn.prepareStatement(SQL_UPDATE_BIRTHDATE);
			
			pstmt.setString(1, "2020-01-01");
			pstmt.setInt(2, 10);
			cnt = pstmt.executeUpdate();
			System.out.println(cnt + "개 행(row) UPDATE 성공");
			
			System.out.println();
			System.out.println("SELECT");
			pstmt.close();
			
			pstmt = conn.prepareStatement(SQL_SELECT_ALL);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String no = rs.getString(COL_LABEL_NO);
				String name = rs.getString(COL_LABEL_NAME);
				String birthdate = rs.getString(COL_LABEL_BIRTHDATE);
				System.out.println(no + " | " + name + " | " + birthdate);
			}
			
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close(); 
				if(pstmt != null)pstmt.close();
				if(conn != null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	} // end main()

} // end class DB03Main






















