package practice.game369;

public class Game369 {
	public static void main(String[] args) {

		int cnt = 0;
		int line = 10;		 //줄 길이
		int maxNum = 100; 	 // 최대 숫자
		
		for (int i = 1; i <= maxNum ; i++) {
			cnt++;
			int tensPlace;
			int unitsPlace;
			
			tensPlace = (i / 10); // 십의 자리  		// 한자리수: ten = 0  * 으로 찍힘
			unitsPlace = (i % 10); // 일의 자리 		// 10의 배수  k = 0
			
			if(unitsPlace != 0 && tensPlace != 0) {
				
				if(tensPlace % 3 == 0 || unitsPlace % 3 == 0) 
					System.out.print("*\t");
				 else 
					System.out.print(i + "\t");
				
				
			} else if(tensPlace == 0) { // 한자리수(ten = 0) 일 때, 모두 * 일 경우 제외
				
				if(unitsPlace % 3 == 0) 
					System.out.print("*\t");
				 else 
					System.out.print(i + "\t");
				
			} else if(unitsPlace == 0 ) { // 10의 배수(one = 0) 일 때 ,모두 * 일 경우 제외
				
				if(tensPlace % 3 == 0) 
					System.out.print("*\t");
				 else 
					System.out.print(i + "\t");
			}
				
				
				if(cnt % line == 0) { // 줄바꿈
					System.out.println();
				} // 줄바꿈 end
				
			} // for 문 end
		
	} // main() end 
	
} // class end
