package kr.s13.iostream.input;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamMain {
	public static void main(String[] args) {
		FileInputStream fis = null;
		//아스키코드를 받을 변수
		int readbyte;
		byte[] readbyte2;
		try {
			                         //상대 경로 명시
			fis = new FileInputStream("file.txt");
			//파일의 정보를 한 문자씩 읽어들여 아스키코드로 반환하는데
			//이에 영문 이외의 문자는 깨지며
			//콘솔에서는 ctrl+z를 눌러야 멈추지만 파일에서는 다 읽으면 알아서 -1 반환
			//Standard일 때는 System.in.read()였던 것이 fis.read()로 바뀐 것뿐임
			/*while((readbyte = fis.read()) != -1) {
				//아스키코드가 뜻하는 문자
				System.out.print((char)readbyte);
			}
			*/
			
			//영문 이외의 문자도 처리 가능
			                    //available(): byte 배열의 길이 반환 메서드
			readbyte2 = new byte[fis.available()];
			
			//read(byte[]): 파일로부터 읽어들인 데이터를 자체적으로 루프 돌며 byte[]에 저장
			fis.read(readbyte2);
			                 //String 생성자가 byte[] -> String으로 변환
			System.out.println(new String(readbyte2));
			
			//파일을 읽어 오려고 하는데 없을 경우 발생하는 예외
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			//자원정리: FileInputStream 객체가 다 읽어온 후에 빠르게 소멸될 수 있도록 자원 끊기
			//참조변수 명만 달라질 뿐 자원 정리 내용은 똑같음
			if(fis!=null)try {fis.close();}catch(IOException e) {}
		}
	}
}
