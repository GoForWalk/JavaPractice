package 반복제어문2.자가진단08;

public class Main {
	public static void main(String[] args) {
		
		int startDan = 2;
		int endDan  = 4 ;
		int colunm = 5;
		
		for (int i = startDan; i <= endDan; i++) {
			for (int j = 1; j <= colunm; j++) {
				System.out.printf("%d * %d = %2d   ", 
						i, j, (i*j));
			}
			System.out.println();
		}
	}
}


