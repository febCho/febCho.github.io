package kr.s26.lang.string;

public class StringMain05 {
	public static void main(String[] args) {
		/*
		 * [실습]
		 * str 변수에 저장된 값을 대문자 -> 소문자로
		 * 소문자 -> 대문자로 변환하시오.
		 * 
		 * [출력 예시]
		 * ABCmdYE-4w?ewZZ
		 * 
		 */
		
		String str = "abcMDye-4W?EWzz";
		String result = "";
		
		for(int i=0;i<str.length();i++) {
			char c = str.charAt(i);
			if(c >= 65 && c <= 90) {//대문자
				//문자를 문자열로 변환(String.valueOf)
				//대문자를 소문자로 변환(toLowerCase)
				result += String.valueOf(c).toLowerCase();
			}else if(c >= 97 && c <= 122) {//소문자
				//문자를 문자열로 변환(String.valeOf)
				//소문자를 대문자로 변환(toUpperCase)
				result += String.valueOf(c).toUpperCase();
			}else {//대소문자가 아님
				result += c;//변환 작업이 없어 그냥 누적 o
			}
		}
		System.out.println(result);
		
	}
}
