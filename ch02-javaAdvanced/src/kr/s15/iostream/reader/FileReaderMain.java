package kr.s15.iostream.reader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderMain {
	public static void main(String[] args) {
		FileReader fr = null;
		//유니코드 받을 변수
		int readChar;
		try {
			//문자 입력 스트림(2bytes 입력 처리)
			fr = new FileReader("file.txt");
			
			//파일로부터 데이터를 한 문자씩 읽어들여 유니코드로 반환
			while((readChar = fr.read())!=-1) {//-1이면 더 이상 읽을 게 없다는 뜻
				System.out.print((char)readChar);
			}
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			//자원정리
			if(fr!=null)try {fr.close();}catch(IOException e) {}
		}
	}
}
