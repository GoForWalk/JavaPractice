package 배열1.자가진단02;

public class Main {

	public static void main(String[] args) {
		
		int [] intArr = new int[10];
		for (int i = 0; i < intArr.length; i++) {
			intArr[i] = i + 1;
			System.out.print(intArr[i] + " ");
		}
	}

}
