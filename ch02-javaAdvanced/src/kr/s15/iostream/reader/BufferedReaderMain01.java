package kr.s15.iostream.reader;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BufferedReaderMain01 {
	public static void main(String[] args) {
		//객체 선언 및 초기화(finally 에러 사라짐)
		BufferedReader br = null;
		try {
			//                  문자 스트림 <------ 바이트 스트림(표준 입력)
			br = new BufferedReader(new InputStreamReader(System.in));
					
			System.out.print("당신의 이름: ");
			String name = br.readLine();
			System.out.println(name);
					
			System.out.print("당신의 나이: ");
					          //String -> int
			int age = Integer.parseInt(br.readLine());
			System.out.println(age);
					
			//나이 입력 시 숫자가 아니면 아래 에러 발생
		}catch(NumberFormatException e) {
			System.out.println("숫자를 입력하세요");
		}catch(IOException e) {
			System.out.println("입력 오류가 발생하였습니다");
		}finally {
			if(br!=null)try {br.close();}catch(IOException e) {}
		}
	}
}
