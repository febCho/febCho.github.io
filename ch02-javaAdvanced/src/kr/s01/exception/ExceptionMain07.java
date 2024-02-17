package kr.s01.exception;

import java.util.Scanner;

//사용자 정의 예외 클래스
class NegativeNumberUseException extends Exception{
	//생성자를 만들면서 예외로 만들어줄 케이스 명칭을 사용해 객체를 만들어 줄 것
	public NegativeNumberUseException(String str) {
		super(str);
	}
}

public class ExceptionMain07 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("0 이상만 입력: ");
		try {
			int a = input.nextInt();
			if(a>=0) {
				System.out.println("입력한 숫자: " + a);
			}else {//0 미만일 경우 예외 던져줌
				throw new NegativeNumberUseException("음수는 사용할 수 없습니다.");
				//메소드가 아니니까 throws 예약어를 적어주진 않아도 됨.
				//그냥 예외 객체 생성해서 try~catch로 던져 주기
			}
		}catch(NegativeNumberUseException e) {
			System.out.println(e.getMessage());
		}catch(Exception e) {//숫자가 아닌 문자를 입력할 경우
			System.out.println("예외 발생");
		}finally {//객체가 생성된 후여야만 자원 정리를 함
			if(input!=null) input.close();
		}
	}
}
