package kr.s16.iostream.writer;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterMain {
	public static void main(String[] args) {
		FileWriter fw = null;
		try {
			//문자 출력 스트림
			//덮어 쓰기와 이어 쓰기 모두 가능
			fw = new FileWriter("fileWriter.txt");
			
			//파일에 저장할 문자열
			String message = "안녕하세요 FileWriter 테스트\n오늘은 수요일"+
			                 System.getProperty("line.separator")+
			                 "내일은 목요일";
			
			//getBytes()로 바꾸거나 할 필요 없음, 문자 출력 스트림이기 때문에
			fw.write(message);
			//버퍼에 저장된 데이터를 버퍼를 비우고 파일로 전송
			fw.flush();
			
			System.out.println("파일을 생성하고 내용을 기술함");
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			if(fw!=null)try {fw.close();}catch(IOException e) {}	
		}
	}
}
