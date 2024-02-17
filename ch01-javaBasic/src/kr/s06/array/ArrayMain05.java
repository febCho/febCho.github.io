package kr.s06.array;

public class ArrayMain05 {
	public static void main(String[] args) {
		//배열 선언 및 생성, 초기화
		int[] array = {10, 20, 30, 40, 50};
		            // 0,  1,  2,  3,  4, length = 5
		
		//(전통적) 반복문을 이용한 배열의 요소 출력
		for(int i=0;i<array.length;i++) {
			System.out.println("array[" + i + "]: " + array[i]);
		}
		System.out.println("===================");
		
		//개선된 루프(확장 for문)
		for(int num: array) {
			System.out.println(num);
		}
	}
}
