package ams;

public class AmsField {
	//�װ����ȣ, �װ���, �ִ�°���, �����, ������
	String[][] arPlane = new String[100][5];
	int insertCnt;
	
	//�ߺ��˻�
	String[] checkDup(String plane_num) {
		String[] plane = null;
		for (int i = 0; i < insertCnt; i++) {
			if(arPlane[i][0].equals(plane_num)) {
				plane = arPlane[i];
			}
		}
		return plane;
	}
	
	//�߰�
	boolean insert(String[] plane) {
		boolean check = false;
		if(checkDup(plane[0]) == null) {
			arPlane[insertCnt] = plane;
			insertCnt++;
			check = true;
		}
		return check;
	}
	//����
	
	//����
	
	//�˻� ���
	String getPrintForm(int[] arIdx) {
		String result = "�� : " + arIdx.length + "��\n"
				+ "�װ����ȣ/�װ���/�ִ�°���/�����/������";
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
	
	//�˻�
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
		
		return temp == null ? "�˻� ��� ����" : temp;
	}
	
	//���
	String selectAll() {
		String result = null;
		if(insertCnt !=0) {
			int[] arIdx = new int[insertCnt];
			for(int i=0; i<arIdx.length; i++) {
				arIdx[i] = i;
			}
			result = getPrintForm(arIdx);
		}
		return result == null ? "��� ����" : result;
	}
}






