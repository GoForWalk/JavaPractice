package phonebook06.db;

import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;



// CONTROLLER 객체
// 어플리케이션의 동작, 데이터 처리(CRUD), (Business logic 담당)

public class PhonebookManager implements Pb, Closeable {

//	public static final String PB_DATA_DIR = "data";
//	public static final String PB_DATA_FILE = "phonebook.dat";
//	private File pbDir;
//	private File pbFile;
//
//	
//
//	private ArrayList<PhonebookModel> pbList = new ArrayList<PhonebookModel>();

	// TODO : DB 를 위한 변수들 선언해야 함!!! ^~^!!
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	// singleton 적용

	private PhonebookManager() { // ** 변경점

		// TODO
		// JDBC 프로그래밍 ^^
		// 	클래스 로딩 ^^
		// 	연결 Connection ^^
		// 	statement (필요하다면) 생성
		
		try {
			// OracleDriver 클래스를 메모리에 로딩
			Class.forName(DRIVER);
			
			conn = DriverManager.getConnection(URL, USER, PASSWD);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}

	private static PhonebookManager instance = null;

	public static PhonebookManager getInstance() {
		if (instance == null) {
			instance = new PhonebookManager();
		}
		return instance;
	}// end getInstance()

	// 전화번호부 생성 등록
	
	
	@Override
	public int insert(String name, String phoneNum, String memo) {
//
		// 매개변수 검증 : 이름 필수 **
		if (name == null || name.trim().length() == 0) {
			throw new PhonebookException("insert() 이름 입력오류: ", Pb.ERR_EMPTY_STRING);
		}

		int cnt = 0;

		// TODO
		// SQL_INSERT 사용하여 INSERT 
		// PrepareStatement 사용!!! -> 사용하고 여기서 close 필수!!!
		// 다른거 말고 preparestatement 만 클로징!!
		
		try {
			pstmt = conn.prepareStatement(SQL_INSERT);
			
			pstmt.setString(1, name);
			pstmt.setString(2, phoneNum);
			pstmt.setString(3, memo);
			
			cnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cnt;
	}

	//
	@Override
	public PhonebookModel[] selectAll() {

		// TODO
		// SQL_SELECT_ALL 사용
		ArrayList<PhonebookModel> list = new ArrayList<PhonebookModel>();
		
		try {
			pstmt = conn.prepareStatement(SQL_SELECT_ALL);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String birthdate = "";
				Date d = rs.getDate(COL_LABEL_REGDATE);
				Time t = rs.getTime(COL_LABEL_REGDATE);
				
				birthdate = new SimpleDateFormat("yyyy-MM-dd").format(d)
							+ " " +
							new SimpleDateFormat("hh:mm:ss").format(t);
				
				java.util.Date date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(birthdate);
				
				
				list.add( new PhonebookModel(
						rs.getInt(COL_LABEL_UID), 
						rs.getString(COL_LABEL_NAME), 
						rs.getString(COL_LABEL_PHONENUM), 
						rs.getString(COL_LABEL_MEMO),
						date));
				// timestamp
			}
			
		}
		 catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} finally {
		
			try {
				rs.close();
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		// 나중에 위에서 클로즈 해보기
		
		
		return list.toArray(new PhonebookModel[list.size()]); // 
	}

	// 특정 uid의 데이터 검색 리턴
	// 못찾으면 null
	@Override
	public PhonebookModel selectByUid(int uid) {
		
		// TODO  
		try {
			pstmt = conn.prepareStatement(SQL_SELECT_UID);
			pstmt.setInt(1, uid);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				return new PhonebookModel(
//						rs.getString(COL_LABEL_NAME), 
//						rs.getString(COL_LABEL_PHONENUM), 
//						rs.getString(COL_LABEL_MEMO)
						);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return null; // 못찾으면 null 리턴
	}

	@Override
	public int updateByUid(int uid, String name, String phoneNum, String memo) {

		// 매개변수 검증
		if (uid < 1)
			throw new PhonebookException("update() uid 오류: " + uid, Pb.ERR_UID);

		if (name == null || name.trim().length() == 0)
			throw new PhonebookException("update() 이름 입력 오류" + Pb.ERR_EMPTY_STRING);
		int cnt = 0;
		
		// TODO 
		// SQL_UPDATE_BY_UID 사용!!
		try {
			pstmt = conn.prepareStatement(SQL_UPDATE_BY_UID);
			
			pstmt.setString(1, name);
			pstmt.setString(2, phoneNum);
			pstmt.setString(3, memo);
			pstmt.setInt(4, uid);
			
			cnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return cnt;
	}

	@Override
	public int deleteByUid(int uid) {

		// 매개변수 검증
		if (uid < 1)
			throw new PhonebookException("deleteByUid() uid 오류: " + uid, Pb.ERR_UID);
		
		int cnt = 0;
		
		// TODO
		// SQL_DELETE_BY_UID 사용!!
		try {
			pstmt = conn.prepareStatement(SQL_DELETE_BY_UID);
			
			pstmt.setInt(1, uid);
			
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cnt;
	}

	// 현재 데이터중 가장 큰 uid 값을 찾아서 리턴
	public int getMaxUid() {
		int maxUid = 0;

		// TODO : 옵션!!! 하고싶으면 해 ㅋㅅㅋ
//		for (int index = 0; index < pbList.size(); index++) {
//			if (maxUid < pbList.get(index).getUid()) {
//				maxUid = pbList.get(index).getUid();
//			}
//		}
		try {
			pstmt = conn.prepareStatement(SQL_COUNT_ALL);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return maxUid;
	}

	@Override
	public void close() throws IOException { // close

		// TODO
		// ResultSet
		// statement
		// Connection
		// 들 close();
		try {
			
			if(rs != null)rs.close();
			if(pstmt != null)pstmt.close();
			if(conn != null)conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
		// pbList -> 파일
//		try (
//
//				OutputStream out = new FileOutputStream(new File(pbDir, PB_DATA_FILE));
//				ObjectOutputStream oout = new ObjectOutputStream(out);
//			) {
//			oout.writeObject(pbList);
//			System.out.println("파일 저장 완료");
//		}
//	}

} // class end

// 예외 클래스 정의
// 예외 발생하면 '에러코드' + '에러 메시지'를 부여하여 관리하는게 좋다.

class PhonebookException extends RuntimeException {

	private int errCode = Pb.ERR_GENERIC;

	public PhonebookException() {
		super("Phonebook 예외 발생");
	}

	public PhonebookException(String msg) {
		super(msg);
	}

	public PhonebookException(String msg, int errCode) {
		super(msg);
		this.errCode = errCode;
	}

	@Override
	public String getMessage() {
		String msg = "ERR-" + errCode + "]" + Pb.ERR_STR[errCode] + " " + super.getMessage();

		return msg;
	}

} // end PhonebookException()
