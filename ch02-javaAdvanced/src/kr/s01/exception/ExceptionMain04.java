package kr.s01.exception;

//readLine은 IOException 명시가 꼭 필요하고,
//이는 lang 패키지에 없기 때문에 별도로 import 필요
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ExceptionMain04 {
	/*
	 * throws 예약어의 사용
	 * 메서드에 throws 예외 클래스를 명시하면 메서드 내에 try~catch 블럭을 생략할 수 있고
	 * 예외가 발생하면 예외를 보관해서 메서드를 호출한 곳에 try~catch 블럭을 만들었을 경우
	 * 그곳으로 예외를 보냄
	 */
	public void printData() throws IOException, NumberFormatException{
		//이 안에 try~catch를 쓰면,
		//1. 코드가 너무 길어지고
		//2. 이 메서드 바깥에서는 예외가 발생하지 않았다고 인식할 수 있음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("단 입력: ");
		         //String -> int
		int dan = Integer.parseInt(br.readLine());
		System.out.println(dan + "단");
		System.out.println("===========");
		for(int i=1;i<=9;i++) {
			System.out.println(dan + "*" + i + "=" + dan*i);
		}
	}
	
	public static void main(String[] args) {
			ExceptionMain04 ex = new ExceptionMain04();
			try {
				ex.printData();
			}catch(IOException e) {
				System.out.println("입력 시 오류 발생");
			}catch(NumberFormatException e) {
				System.out.println("숫자가 아닙니다.");
			}
	}
}
