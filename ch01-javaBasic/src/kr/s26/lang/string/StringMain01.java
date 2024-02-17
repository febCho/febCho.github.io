package kr.s26.lang.string;

public class StringMain01 {
	public static void main(String[] args) {
		//암시적으로 객체 생성
		//암시적으로 객체를 생성할 때 문자열이 같으면 같은 객체를 공유
		String str1 = "abc";
		String str2 = "abc";
		
		//객체 비교
		if(str1 == str2) {//객체 비교 시 비교연산자 활용
			System.out.println("str1과 str2는 같은 객체");
		}else {
			System.out.println("str1과 str2는 다른 객체");
		}
				
		//문자열 비교
		if(str1.equals(str2)) {
			System.out.println("str1의 내용(문자열)과 str2의 내용(문자열)이 같다.");
		}else {
			System.out.println("str1의 내용(문자열)과 str2의 내용(문자열)이 다르다.");
		}
				
		System.out.println("==================================");
		
		//명시적으로 객체 생성
		//명시적으로 객체 생성하면 같은 문자열을 사용해도 각각 새로운 객체를 생성
		String str3 = new String("Hello");
		String str4 = new String("Hello");
				
		//객체 비교
		if(str3 == str4) {
			System.out.println("str3와 str4는 같은 객체");
		}else {
			System.out.println("str3와 str4는 다른 객체");
		}
				
		//문자열 비교
		if(str3.equals(str4)) {
			System.out.println("str3의 내용(문자열)과 str4의 내용(문자열)이 같다.");
		}else {
			System.out.println("str3의 내용(문자열)과 str4의 내용(문자열)이 다르다.");
		}
		
		System.out.println("==================================");
		
		//equals는 대소문자를 구분한다.
		String str5 = "bus";
		String str6 = "BUS";
		
		if(str5.equals(str6)) {
			System.out.println("str5와 str6의 문자열은 같다");
		}else {
			System.out.println("str5와 str6의 문자열은 다르다.");
		}
		
		System.out.println("==================================");
		
		//대소문자를 구분하지 않고 문자열 비교
		if(str5.equalsIgnoreCase(str6)) {
			System.out.println("[대소문자 구분 없이 비교]str5와 str6의 문자열은 같다");
		}else {
			System.out.println("[대소문자 구분 없이 비교]str5와 str6의 문자열은 다르다.");
		}
	}
}
