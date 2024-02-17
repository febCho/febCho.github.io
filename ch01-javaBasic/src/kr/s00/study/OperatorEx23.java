package kr.s00.study;

public class OperatorEx23 {
	public static void main(String[] args) {
		String str1 = "abc";
		String str2 = new String("abc");
		
		System.out.printf("\"abc\"==\"abc\" ? %b%n", "abc" == "abc");
		System.out.printf(" str1==\"abc\" ? %b%n", str1 == "abc");
		System.out.printf(" str2==\"abc\" ? %b%n", str2 == "abc");//내용은 같지만 서로 다른 객체이기 때문
		System.out.printf("str1.equals(\"abc\") ? %b%n", str1.equals("abc"));
		System.out.printf("str2.equals(\"abc\") ? %b%n", str2.equals("abc"));//equals()는 객체가 달라도 문자열이 같으면 true
		System.out.printf("str2.equals(\"ABC\") ? %b%n", str2.equals("ABC"));//단, equals()는 대소문자를 구분함
		System.out.printf("str2.equalsIgnoreCase(\"ABC\") ? %b%n", 
										str2.equalsIgnoreCase("ABC"));//대소문자 구별을 원치 않는다면 equalsIgnoreCase() 사용
	}
}
