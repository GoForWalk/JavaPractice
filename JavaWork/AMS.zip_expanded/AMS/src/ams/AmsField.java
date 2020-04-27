package ams;

public class AmsField {
	//항공기번호, 항공사, 최대승객수, 출발지, 도착지
	String[][] arPlane = new String[100][5];
	int insertCnt;
	
	//중복검사
	String[] checkDup(String plane_num) {
		String[] plane = null;
		for (int i = 0; i < insertCnt; i++) {
			if(arPlane[i][0].equals(plane_num)) {
				plane = arPlane[i];
			}
		}
		return plane;
	}
	
	//추가
	boolean insert(String[] plane) {
		boolean check = false;
		if(checkDup(plane[0]) == null) {
			arPlane[insertCnt] = plane;
			insertCnt++;
			check = true;
		}
		return check;
	}
	//수정
	
	//삭제
	
	//검색 결과
	String getPrintForm(int[] arIdx) {
		String result = "총 : " + arIdx.length + "건\n"
				+ "항공기번호/항공사/최대승객수/출발지/도착지";
		for (int i = 0; i < arIdx.length; i++) {
			result += arIdx[i] + ".";
			for (int j = 0; j < arPlane[i].length; j++) {
				result += arPlane[arIdx[i]][j];
				result += j == arPlane[i].length - 1 ? "\n" : " / ";
			}
		}
		if(arIdx.length == 0) {
			result = null;
		}
		return result;
	}
	
	//검색
	String select(int idx, String keyword) {
		String[] arTemp = null;
		int[] arIdx = null;
		String temp = "";
		
		for (int i = 0; i < insertCnt; i++) {
			if(arPlane[i][idx].equals(keyword)) {
				temp += i + ",";
			}
		}
		arTemp = temp.split(",");
		arIdx = new int[arTemp.length];
		
		for (int i = 0; i < arIdx.length; i++) {
			arIdx[i] = Integer.parseInt(arTemp[i]);
		}
		
		temp = getPrintForm(arIdx);
		
		return temp == null ? "검색 결과 없음" : temp;
	}
	
	//목록
	String selectAll() {
		String result = null;
		if(insertCnt !=0) {
			int[] arIdx = new int[insertCnt];
			for(int i=0; i<arIdx.length; i++) {
				arIdx[i] = i;
			}
			result = getPrintForm(arIdx);
		}
		return result == null ? "목록 없음" : result;
	}
}






