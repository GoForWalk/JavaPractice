package practice;


public class Test {
	
		private int num;

 		static int count = 0;

//		//  Singleton 패턴
//		// 기본 생성자
//		private Test() { // pirvate으로 접근 제어
//		   count++;
//		   System.out.println(count + "번째 인스턴스 생성");
//		}
//		
//		private static Test instance = null;
//
//		public static Test getInstance() {
//		   if(instance == null) {
//		       instance = new Test();
//		   }
//		   return instance;
//		}
 		
 		public static void main(String[] args) {
			
 			String s = "2*3";
// 			int i = Integer.parseInt(s);
 			int i = 2*3;
 			System.out.println(i);
 			
		}
 		
		
		
}
