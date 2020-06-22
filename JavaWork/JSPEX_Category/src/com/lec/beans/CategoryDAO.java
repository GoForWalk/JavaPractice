package com.lec.beans;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import common.D;

public class CategoryDAO {
	
	// TODO 
	// 1. connection
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public CategoryDAO() {
		try {
			Class.forName(D.DRIVER);
			conn = DriverManager.getConnection(D.URL, D.USERID, D.USERPW);
			System.out.println("오라클 연결 완료");
		} catch (Exception e) {
			e.printStackTrace();
		}
	} // end 생성자
	
	// DB 자원 반납
	public void close() throws SQLException {
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		if(stmt != null) stmt.close();
		if(conn != null) conn.close();
	} // end close()
	
	public CategotyDTO [] createArray(ResultSet rs) throws SQLException {
		CategotyDTO [] arr = null;
		
		ArrayList<CategotyDTO> list = new ArrayList<CategotyDTO>();
		
		while(rs.next()) {
			int uid = rs.getInt("uid");
			String name = rs.getString("name");
			int depth = rs.getInt("depth");
			int parent = rs.getInt("parent");
			int order = rs.getInt("order");
		
			CategotyDTO dto = new CategotyDTO(uid, name, depth, parent, order);
			list.add(dto);
		
		}// end while
		
		int size = list.size();
		
		if(size == 0) return null;
		
		arr = new CategotyDTO[size];
		list.toArray(arr); // List -> 배열
		return arr;
	}
	
	
	// 특정 depth 의 특정 parent 인 카테고리를 읽어오기 (SELECT)
	public CategotyDTO [] selectByDepthParent(int depth, int parent) throws SQLException {
		CategotyDTO [] arr = null;
		
		try {
			pstmt= conn.prepareStatement(D.SQL_CATEGORY_BY_DEPTH_N_PARENT);
			pstmt.setInt(1, depth);
			pstmt.setInt(2, parent);
			rs = pstmt.executeQuery();
			arr = createArray(rs); // createArray() 만들기
		} finally {
			close();
		} 
		return arr;
	}
	
	
	
	
}
