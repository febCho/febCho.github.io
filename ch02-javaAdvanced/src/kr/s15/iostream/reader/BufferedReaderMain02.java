package kr.s15.iostream.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

public class BufferedReaderMain02 {
	public static void main(String[] args) {
		 FileReader fr = null;
		 BufferedReader br = null;
		 String msg;
		 try {
			 fr = new FileReader("file.txt");
			 br = new BufferedReader(fr);
			 
			 //한 라인의 데이터를 읽어들여 변수에 저장하고 출력 (!= 한 문자씩)
			 while((msg = br.readLine())!=null) {
				 //readLine()이 엔터 처리는 못하기 때문에 println으로
				 //다음 라인의 데이터는 구분하여 출력해줄 수 있게 함
				 System.out.println(msg);
			 }
		 }catch(FileNotFoundException e) {
			 e.printStackTrace();
		 }catch(IOException e) {
			e.printStackTrace();
		}finally {
			if(br!= null)try {br.close();}catch(IOException e) {}
			if(fr!=null)try {fr.close();}catch(IOException e) {}
		}
	}
}
