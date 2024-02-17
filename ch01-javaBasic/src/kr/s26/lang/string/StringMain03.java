package kr.s26.lang.string;

public class StringMain03 {
	public static void main(String[] args) {
		String s1 = "  aBa  ";//앞 뒤로 공백 두 칸씩
		String s2 = "abc";
		int a = 100;
		String msg = null;//객체 생성이 되지 않아 주소가 없다는 뜻
		
		//문자열을 대문자로 반환
		msg = s1.toUpperCase();
		System.out.println("msg:" + msg);
		
		//문자열을 소문자로 반환
		msg = s1.toLowerCase();
		System.out.println("msg:" + msg);
		
		//old문자를 new문자로 대체
		msg = s1.replace("aB", "b");
		System.out.println("msg:" + msg);
		
		//앞 뒤 공백 제거 - 문자열 중간에 있는 공백은 불가
		msg = s1.trim();
		System.out.println("msg:" + msg);
		
		//지정한 문자열이 포함되어 있으면 true 반환
		boolean f = s1.contains("aB");
		System.out.println("f:" + f);
		
		//지정한 문자열로 시작할 경우 true 반환
		f = s2.startsWith("ab");
		System.out.println("f:" + f);
		
		//지정한 문자열로 끝나는 경우 true 반환
		f = s2.endsWith("bc");
		System.out.println("f:" + f);
		
		//int -> String
		msg = String.valueOf(a);
		msg = a + "";//"": 빈 문자열 = 형식적인 문자열 = 객체는 있는데 내용이 없다.
		System.out.println(msg.length());
	}
}
