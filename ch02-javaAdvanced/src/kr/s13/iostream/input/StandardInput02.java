package kr.s13.iostream.input;

import java.io.IOException;

public class StandardInput02 {
	public static void main(String[] args) {
		//문자의 아스키 코드 값을 저장해 주기 위한 변수 세팅
		int input = 0;
		try {
			//직접 입력받는 과정이기 때문에 명시적으로 -1을 만들려면 ctrl + z
			while((input = System.in.read()) != -1) {
				System.out.println(input + ", (char)input : " + (char)input);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
