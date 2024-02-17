package kr.s00.study;

public class StringEx {
	public static void main(String[] args) {
		String name = "Ja" + "va";
		String str = name + 8.0;
		
		System.out.println(name);
		System.out.println(str);
		System.out.println(7 + " ");//공백
		System.out.println(" " + 7);//공백
		System.out.println(7 + "");//빈 문자열
		System.out.println("" + 7);//빈 문자열 -> String
		System.out.println("" + "");
		System.out.println(7 + 7 + "");//14 + 빈 문자열
		System.out.println("" + 7 + 7);//77 -> 기본형 타입의 값을 문자열로 변환할 때에는
		                              //빈 문자열을 더해주면 된다.
	}
}
