package kr.s13.iostream.input;

import java.io.IOException;

public class StandardInput01 {
	public static void main(String[] args) {
		//자바의 기본 입력: 바이트 스트림(1byte 입력)
		
		try {
		System.out.print("영문자 1개 입력: ");
		int a = System.in.read();//문자 하나를 입력 받아서 아스키 코드로 반환
		System.out.println(a + ", " + (char)a);
				
		//아래 두 코드를 입력하지 않으면 숫자 입력 칸에 13이 입력되고
		//\n으로 인해 다음 줄로 이동하게 됨
		System.in.read(); //enter(\r\n) 처리: \r이 숫자 입력으로 가 13 출력되는 것 방지
		System.in.read(); //enter(\r\n) 처리: \n이 숫자 입력으로 가 10이 출력되는 것 방지
				
		System.out.println("=======================");
				
		System.out.print("숫자 1개 입력: ");
		int b = System.in.read() - 48;
		System.out.println(b);
				
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
