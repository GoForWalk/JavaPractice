package com.lec.java.file08;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/* Object Filter Stream
 Program <=== ObjectInputStream <=== FileInputStream <=== File
 Program ===> ObjectOutputStream ===> FileOutputStream ===> File

java.lang.Object
 └─ java.io.OutputStream
    └─ java.io.ObjectOutputStream
 
java.lang.Object
 └─ java.io.InputStream
     └─ java.io.ObjectInputStream


 Object Stream: 객체의 입출력을 위한 스트림
 사용법은 다른 Filter Stream(Buffered I/O, Data I/O)과 비슷
 Object 스트림의 입출력 대상이 되는 클래스는 *** Serializable 인터페이스를 구현 ***
 클래스의 일부 멤버 변수를 직렬화(Serialization)의 대상에서 제외시키려면,
 transient 키워드를 사용
*/
public class File08Main {
	
	public static final String FILEPATH  = "temp/member.dat";

	public static void main(String[] args) {
		System.out.println("Object Filter Stream");
		

		try(
				OutputStream out = new FileOutputStream(FILEPATH);
				ObjectOutputStream oOut = new ObjectOutputStream(out);
				
				InputStream in = new FileInputStream(FILEPATH);
				ObjectInputStream oIn = new ObjectInputStream(in);
				
				){
			// 멤버 데이터
			
			Member m1 = new Member("root", "root1234");
			Member m2 = new Member("guest", "guest");
			Member m3 = new Member("admin", "admin123456");
			
			oOut.writeObject(m1);
			oOut.writeObject(m2);
			oOut.writeObject(m3);
			
			
			// 파일에서 Object 타입으로 읽기
			Member dataRead;
			
			// 읽는 방법1 : 매번 readObject() 호출
//			dataRead = (Member) oIn.readObject();
//			dataRead.displayInfo();
//			dataRead = (Member) oIn.readObject();
//			dataRead.displayInfo();
//			dataRead = (Member) oIn.readObject();
//			dataRead.displayInfo();
			
			// 읽는 방법2 : 무한루프로 readObject() 호출...
			// EOFException 으로 잡기
			// End Of File
			
			while(true) {
				dataRead = (Member)oIn.readObject();
				dataRead.displayInfo();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EOFException e) { // EOFException 은 IOException 을 상속한다.
			System.out.println("파일 끝까지 읽었습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		System.out.println("\n프로그램 종료");
		
	} // end main()

} // end class
















