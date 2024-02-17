package kr.s06.array;

public class ArrayMain06 {
	public static void main(String[] args) {
		//문자열을 저장하는 배열 사용하기
		//배열 선언 및 생성
		String[] array = new String[3];
		
		//배열의 초기화
		array[0] = "Java";
		array[1] = "Oracle";
		array[2] = "HTML";
		
		//반복문을 이용한 배열의 요소 출력
		for(int i=0;i<array.length;i++) {
			System.out.println(array[i]);
		}
		System.out.println("=================");
		
		//확장 for문을 이용한 배열의 요소 출력
		for(String str : array) {
			System.out.println(str);
		}
	}
}
