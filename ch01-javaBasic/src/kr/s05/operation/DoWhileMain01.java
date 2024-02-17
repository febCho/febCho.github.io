package kr.s05.operation;

public class DoWhileMain01 {
	public static void main(String[] args) {
		int su = 0;
		String str = "Hello world";
		
		//선 처리, 후 비교
		do {//6개 출력
			System.out.println(str);
		}while(su++ < 5);
		System.out.println("============");
		
		int su2 = 0;
		
		//선 비교, 후 처리
		while(su2++ < 5) {//5개 출력
			System.out.println(str);
		}
	}
}
