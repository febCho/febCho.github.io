package kr.s01.exception;

public class ExceptionMain03 {
	public static void main(String[] args) {
		int var = 50;
		
		//다중 catch문
		//예외가 발생하면 예외 객체가 전달되는 catch 블럭으로 이동해서 수행문 실행
		
		//args(배열)에 외부로부터 데이터를 입력받기
		try {
			          //String -> int(배열 안에 있는 데이터가 String이라)
			int data = Integer.parseInt(args[0]);
			System.out.println(var/data);
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("입력한 데이터가 없습니다.");
		}catch(NumberFormatException e) {
			System.out.println("숫자가 아닙니다.");	
		}catch(ArithmeticException e) {
			System.out.println("0으로 나눌 수 없습니다.");
		}catch(Exception e) {
			System.out.println("나머지 예외는 여기로~~");
		}
		System.out.println("프로그램 종료!");
	}
}
