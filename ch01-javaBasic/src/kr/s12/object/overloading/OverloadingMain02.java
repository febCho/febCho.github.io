package kr.s12.object.overloading;

public class OverloadingMain02 {
	//전달되는 인자의 타입을 모두 String으로 변환해서 문자열의 길이를
	//구하는 메서드 만들기 ex. 10 -> "10" (length: 2)
	public void getLength(int n) {
		//String -> int : Integer.parseInt();
		String s = String.valueOf(n);//int -> String
		//System.out.println(s + "의 길이: " + s.length());
		getLength(s);
	}
	public void getLength(float n) {
		String s = String.valueOf(n);//float -> String
		//System.out.println(s + "의 길이: " + s.length());
		getLength(s);
	}
	public void getLength(String s) {
		System.out.println(s + "의 길이: " + s.length());
		//위 출력식이 getLength 메서드에서 전부 중복
		//이렇게 동일한 코드가 반복되는 건 좋은 코드가 아님
		//따라서 메서드 안에서 다른 메서드를 호출하는 방식으로 재활용성을 높여야 함
	}
	public static void main(String[] args) {
		OverloadingMain02 om = new OverloadingMain02();
		om.getLength(10000);
		om.getLength(2.08f);
		om.getLength("나는 내가 대견해");
	}
}
