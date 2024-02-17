package kr.s01.exception;

public class ExceptionMain02 {
	public static void main(String[] args) {
		//예외 처리
		
		int[] array = {10,20,30};
		for(int i=0;i<=array.length;i++) {
			//예외처리
			//예외가 발생해도 정상 종료될 수 있도록 프로그램적으로 처리하는 것을 말함
			try {
				//예외가 발생할 가능성이 있는 코드를 명시
				//예외가 발생하면 예외가 발생한 코드의 실행을 멈추고 catch 블럭으로 이동
				System.out.println("array[" + i + "]: " + array[i]);;
				
				//인자: 예외 발생 시 생성되는 예외 객체의 타입
			}catch(ArrayIndexOutOfBoundsException e) {
				//예외가 발생하면 catch 블럭으로 이동해서
				//예외가 발생한 이류를 설명하거나 대체 코드를 작성하여 대신 작동하게 함
				System.out.println("없는 인덱스 호출!!");
			}//catch
		}//for
		
		System.out.println("프로그램 끝");
	}
}
