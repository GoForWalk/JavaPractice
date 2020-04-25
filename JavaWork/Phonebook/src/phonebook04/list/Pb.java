package phonebook04.list;

// Controller 인터페이스
// 동작 정의하기 전에 '동작 설계'

public interface Pb { // 인터페이스에서 유지, 보수하는데 유용하다
	
	public static final String VERSION = "전화번호부 4.0";
	
	public abstract int insert(String name, String phoneNum, String memo); /* 1 */
	public abstract PhonebookModel[] selectAll(); /* 2 */
	public abstract PhonebookModel selectByUid(int uid); /* 3 */
	public abstract int updateByUid(int uid,String name, String phoneNum, String memo); /* 4 */
	public abstract int deleteByUid(int uid); /* 5 */
	
//	public static final int QUERY_FAIL = 0;

	// 발생 가능한 에러사항
	
	// 에러 코드 상수
	public static final int ERR_GENERIC = 0;// 일반 오류
	public static final int ERR_INDEXOUTOFRANGE = 1;// index 범위 벗어남
	public static final int ERR_EMPTY_STRING = 2;// 입력문자열이 empty (혹은 null) 인 경우
	public static final int ERR_UID = 3;// uid 가 없는 경우
	 
	//에러 문자열
	public static final String[] ERR_STR = {
			"일반 오류", //0
			"인덱스 오류", //1
			"문자열 오류", //2
			"UID 오류", //3
		
	};
		
	
	
}
