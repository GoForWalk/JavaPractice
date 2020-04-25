package phonebook04.list;

import java.util.ArrayList;


// CONTROLLER 객체
// 어플리케이션의 동작, 데이터 처리(CRUD), (Business logic 담당)


public class PhonebookManager implements Pb {
	
//	public static final int MAX_DATA = 3; //최대 데이터 개수
//	
//	// 배열로 구현.
//	private PhonebookModel[] pbList = new PhonebookModel[MAX_DATA];
//	
//	// 몇개의 데이터가 저장이 되어 있는지
//	private int count = 0;
	
	private ArrayList<PhonebookModel> pbList = new ArrayList<PhonebookModel>();
	
	
	
	// singleton 적용
	
	private PhonebookManager() {}
	private static PhonebookManager instance = null;
	public static PhonebookManager getInstance() {
		if(instance == null) {
			instance = new PhonebookManager();
		}
		return instance;
	}// end getInstance()

	
	// 전화번호부 생성 등록
	@Override
	public int insert(String name, String phoneNum, String memo) {
		
		//매개변수 검증 : 이름 필수 **
		if(name == null || name.trim().length() == 0) {
			throw new PhonebookException("insert() 이름 입력오류: ", Pb.ERR_EMPTY_STRING); 
		}
		PhonebookModel phonebookModel = new PhonebookModel(name, phoneNum, memo);
		phonebookModel.setUid(getMaxUid() + 1);
		
		pbList.add(phonebookModel);
		
		return 1;
	}

	
	//
	@Override
	public PhonebookModel[] selectAll() {
		
		PhonebookModel[] arr = new PhonebookModel[pbList.size()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = pbList.get(i);
		}		
			// List를 배열로 리턴하는 것
		
//	 return	pbList.toArray(new PhonebookModel[pbList.size()]);
		
		return arr; //TODO
	}

	
	// 특정 uid의 데이터 검색 리턴
	// 못찾으면 null
	@Override
	public PhonebookModel selectByUid(int uid) {
		for (int index = 0; index < pbList.size(); index++) {
			if(pbList.get(index).getUid() == uid) {
				return pbList.get(index);  // uid 값 발견하면 리턴
			}
		}
		return null; // 못찾으면 null 리턴
	}

	@Override
	public int updateByUid(int uid, String name, String phoneNum, String memo) {

		
		// 매개변수 검증
		if(uid < 1) 
			throw new PhonebookException("update() uid 오류: " + uid, Pb.ERR_UID);
			
		if(name == null|| name.trim().length() == 0) 
			throw new PhonebookException("update() 이름 입력 오류" + Pb.ERR_EMPTY_STRING);
		
		// 특정 uid 값을 가진 데이터의 배열 인덱스 찾기
		int index = findIndexByUid(uid);
		if(index < 0) 
			throw new PhonebookException("update() 없는 uid: " + uid, Pb.ERR_UID);
		
//		int i = pbList.get(index).getUid();
//		PhonebookModel pb = new PhonebookModel(name, phoneNum, memo);
//		pb.setUid(i);
//		pbList.set(index, pb);
		
		pbList.get(index).setName(name);
		pbList.get(index).setPhoneNum(phoneNum);
		pbList.get(index).setMemo(memo);
		
		return 1;
	}

	@Override
	public int deleteByUid(int uid) {

		// 매개변수 검증
		if(uid < 1) 
			throw new PhonebookException("deleteByUid() uid 오류: " + uid, Pb.ERR_UID);
		
		int index = findIndexByUid(uid);
		if(index < 0)
			throw new PhonebookException("deleteByUid() 없는 uid: " + uid, Pb.ERR_UID);
		
		pbList.remove(index);
		
		return 1;
	}

	// 현재 데이터중 가장 큰 uid 값을 찾아서 리턴
	public int getMaxUid() {
		int maxUid = 0;
		
		for(int index = 0; index < pbList.size(); index++) {
			if(maxUid < pbList.get(index).getUid()) {
				maxUid = pbList.get(index).getUid();
			}
		}
		return maxUid;
	}
	
	// 특정 uid 값을 가진 데이터의 배열 인덱스 찾기
	private int findIndexByUid(int uid) { // 다른데서는 접근 금지
		for(int index = 0; index < pbList.size(); index++) {
			if(pbList.get(index).getUid() == uid){
				return index;
			}
		}
		return -1;
	}
	
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
		String msg = "ERR-" + errCode + "]" + Pb.ERR_STR[errCode] + 
				" " + super.getMessage();
		
		return msg;
	}
	
	
	
} // end PhonebookException()

