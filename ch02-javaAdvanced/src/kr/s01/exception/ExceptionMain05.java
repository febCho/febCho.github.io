package kr.s01.exception;

public class ExceptionMain05 {
	public static void main(String[] args) {
		System.out.println("===예외가 발생하지 않았을 경우===");
		try {
			System.out.println("1");
			System.out.println("2");
		}catch(Exception e) {
			System.out.println("3");
		}finally {
			System.out.println("4");
		}
		System.out.println("프로그램 종료!!");
		
		System.out.println("============================");
		
		System.out.println("===예외가 발생한 경우===");
		try {
			System.out.println("1");
			System.out.println(10/0);//예외 발생
			System.out.println("2");
		}catch(Exception e) {
			System.out.println("3");
		}finally {
			System.out.println("4");
		}
		System.out.println("프로그램 종료!!");
	}
}
