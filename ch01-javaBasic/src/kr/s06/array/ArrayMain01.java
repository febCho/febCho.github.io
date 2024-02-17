package kr.s06.array;

public class ArrayMain01 {
	public static void main(String[] args) {
		char[] ch;//배열 선언
		ch = new char[4];//배열 생성
		
		//배열의 초기화
		ch[0] = 'J';
		ch[1] = 'a';
		ch[2] = 'v';
		ch[3] = 'a';
		
		//배열의 요소 출력
		System.out.println(ch[0]);
		System.out.println(ch[1]);
		System.out.println(ch[2]);
		System.out.println(ch[3]);
		System.out.println("===========");
		
		//반복문을 이용한 배열의 요소 출력
		for(int i=0;i<ch.length;i++) {
			System.out.println("ch[" + i + "]: " + ch[i]);
			//i: index 0~3
		}
		System.out.println("=============");
		
		//배열의 선언, 생성
		int[] it = new int[6];
		//int it[] = new int[6];처럼 자료형 뒤 혹은 배열명 뒤에 [] 위치
		
		//배열의 선언, 생성(명시적 배열 생성), 초기화
		char[] ch2 = new char[] {'자', '바'};
		
		//배열의 선언, 생성(암시적 배열 생성), 초기화
		char[] ch3 = {'강', '남', '구'};
	}
}
