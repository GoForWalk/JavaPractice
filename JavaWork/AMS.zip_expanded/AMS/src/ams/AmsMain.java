package ams;

import javax.swing.JOptionPane;

public class AmsMain {
	public static void main(String[] args) {
		String[] menu = {"�߰�", "����", "����","���","�˻�"};
		int result = JOptionPane.showOptionDialog(null, "", "AMS", JOptionPane.DEFAULT_OPTION,
				JOptionPane.PLAIN_MESSAGE, null, menu, null);
		System.out.println(result);
	}
}
