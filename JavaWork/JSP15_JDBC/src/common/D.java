package common;

/*
 * DB 접속 정보, 쿼리문, 테이블 명, 컬럼명 등은
 * 별도로 관리하던지
 * 
 * 
 */

public class D {

	final String DRIVER= "oracle.jdbc.driver.OracleDriver";
	final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	final String USERID = "scott0316";
	final String USERPW = "tiger0316";
	
	final String SQL_WRITE_DELETE_BY_UID =
			"DELETE FROM test_write WHERE wr_uid = ?";
	
	final String SQL_WRITE_SELECT = 
			"SELECT * FROM test_write ORDER BY wr_uid DESC" 	
		;
	
	// 쿼리문 준비
	final String SQL_WRITE_SELECT_BY_UID = 
			"SELECT * FROM test_write WHERE wr_uid = ? ";
	
	// 쿼리문 준비
		final String SQL_WRITE_UPDATE =
			"UPDATE test_write SET wr_subject =? , wr_content =? WHERE wr_uid = ?";
	
		final String SQL_WRITE_INC_VIEWCNT = 
		 		"UPDATE test_write SET wr_viewcnt = wr_viewcnt + 1 WHERE wr_uid = ?";
		
		
		final String SQL_INSERT = "INSERT INTO test_write " + 
				"(wr_uid, wr_subject, wr_content, wr_name) " +
				"VALUES(test_write_seq.nextval, ?, ?, ?)"
				;
}































