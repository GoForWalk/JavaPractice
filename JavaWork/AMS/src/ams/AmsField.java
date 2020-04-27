package ams;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class AmsField {
	// �װ����ȣ, �װ���, �ִ�°���, �����, ������
	String[][] arPlane = new String[100][5];
	int insertCnt;
	int rowNum;

	// �ߺ��˻�
	String[] checkDup(String plane_num) {
		String[] plane = null;
		for (int i = 0; i < insertCnt; i++) {
			if (arPlane[i][0].equals(plane_num)) {
				plane = arPlane[i];
				rowNum = i;
			}
		}
		return plane;
	}

	// �߰�
	boolean insert(String[] plane) {
		boolean check = false;
		if (checkDup(plane[0]) == null) {
			arPlane[insertCnt] = plane;
			insertCnt++;
			check = true;
		}
		return check;
	}

	// ����(�����, ������)
	void update(int idx, String new_value) {
		arPlane[rowNum][idx + 3] = new_value;
	}

	// ����
	boolean delete(String plane_num) {
		boolean check = false;
		if (checkDup(plane_num) != null) {
			for (int i = rowNum; i < insertCnt; i++) {
				arPlane[i] = arPlane[i + 1];
			}
			check = true;
			insertCnt--;
		}
		return check;
	}

	// �˻� ���
	String getPrintForm(int[] arIdx) {
		String result = "�� : " + arIdx.length + "��\n" + "�װ����ȣ/�װ���/�ִ�°���/�����/������\n";
		for (int i = 0; i < arIdx.length; i++) {
			result += arIdx[i] + 1 + ".";
			for (int j = 0; j < arPlane[i].length; j++) {
				result += arPlane[arIdx[i]][j];
				result += j == arPlane[i].length - 1 ? "\n" : " / ";
			}
		}
		if (arIdx.length == 0) {
			result = null;
		}
		return result;
	}

	// �˻�
	String select(int idx, String keyword) {
		String[] arTemp = null;
		int[] arIdx = null;
		String temp = "";

		for (int i = 0; i < insertCnt; i++) {
			if (arPlane[i][idx].equals(keyword)) {
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

	// ���
	String selectAll() {
		String result = null;
		if (insertCnt != 0) {
			int[] arIdx = new int[insertCnt];
			for (int i = 0; i < arIdx.length; i++) {
				arIdx[i] = i;
			}
			result = getPrintForm(arIdx);
		}
		return result == null ? "��� ����" : result;
	}

	void view() {
		String[] menu = { "�߰��ϱ�", "�����ϱ�", "�����ϱ�", "��Ϻ���", "�˻��ϱ�" };
		String[] update_menu = { "�����", "������" };
		String[] select_menu = { "�װ����ȣ", "�װ���", "�ִ�°���", "�����", "������" };

		int choice = 0;

		while (true) {
			ImageIcon icon = new ImageIcon("src/img/main.gif");
			choice = JOptionPane.showOptionDialog(null, "", "AMS", JOptionPane.DEFAULT_OPTION,
					JOptionPane.PLAIN_MESSAGE, icon, menu, null);

			if (choice == -1) {
				break;
			}

			switch (choice) {
			// �߰�
			case 0:
				String[] temp = ("" + JOptionPane.showInputDialog(null,
						"[�Ʒ��� ���� �Է����ּ���]\n�װ����ȣ,�װ���,�ִ�°���,�����,������", "AMS", JOptionPane.PLAIN_MESSAGE,
						icon, null, null)).split(",");
				if (temp.length == 5) {
					if (insert(temp)) {
						JOptionPane.showMessageDialog(null, "�߰� ����");
					} else {
						JOptionPane.showMessageDialog(null, "�߰� ����(�ߺ��� ����� ��ȣ)");
					}
				} else {
					JOptionPane.showMessageDialog(null, "�߰��� ����� ������ �ùٸ��� �ʽ��ϴ�.");
				}
				break;
			// ����
			case 1:
				if (checkDup(JOptionPane.showInputDialog("�����Ͻ� �װ��� ��ȣ�� �Է��ϼ���.")) != null) {
					choice = JOptionPane.showOptionDialog(null, "", "AMS", JOptionPane.DEFAULT_OPTION,
							JOptionPane.PLAIN_MESSAGE, icon, update_menu, null);

					update(choice, JOptionPane.showInputDialog("���ο� " + update_menu[choice] + "�� �Է��ϼ���."));
					JOptionPane.showMessageDialog(null, "�����Ϸ�");
				} else {
					JOptionPane.showMessageDialog(null, "�����Ͻ� �װ��Ⱑ �������� �ʽ��ϴ�.");
				}
				break;
			// ����
			case 2:
				if (delete(JOptionPane.showInputDialog("�����Ͻ� �װ��� ��ȣ�� �Է��ϼ���."))) {
					JOptionPane.showMessageDialog(null, "���� ����");
				} else {
					JOptionPane.showMessageDialog(null, "�����Ͻ� �װ��Ⱑ �������� �ʽ��ϴ�.");
				}
				break;
			// ���
			case 3:
				JOptionPane.showMessageDialog(null, selectAll());
				break;
			// �˻�
			case 4:
				icon = new ImageIcon("src/img/search.gif");
				choice = JOptionPane.showOptionDialog(null, "", "AMS", JOptionPane.DEFAULT_OPTION,
						JOptionPane.PLAIN_MESSAGE, icon, select_menu, null);

				JOptionPane.showMessageDialog(null, select(choice,
						JOptionPane.showInputDialog("�˻��Ͻ� " + select_menu[choice] + "��(��) �Է��ϼ���")));
				break;
			}
		}
	}

}
