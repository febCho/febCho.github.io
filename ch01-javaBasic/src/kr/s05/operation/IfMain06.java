package kr.s05.operation;

public class IfMain06 {
	public static void main(String[] args) {
		int a = 10;
		float b = 10.0f;
		if(a == b) {//a : int -> float 자동 형변환
			System.out.println("10과 10.0f는 같다.");
		}
	
		char c = '0';
		int d = 0;
		if(c != d) {//c는 int로 형변환 되어 48로 인식
			System.out.println("'0'과 0은 같지 않다.");
		}
		
		char e = 'A';
		int f = 65;
		if(e == f) {
			System.out.println("'A'는 65와 같다.");
		}
	}
}
