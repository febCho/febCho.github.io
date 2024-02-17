package kr.s11.enumtest;

public class EnumMain01 {
	//enum을 사용하지 않고 static 상수를 사용한 경우
	public static final String JAVA = "JAVA";
	public static final String JSP = "JSP";
	public static final String ORACLE = "ORACLE";
		
	public static void main(String[] args) {
		//같은 클래스 내에 있기 때문에 클래스 명 필요 없이 상수 명만
		System.out.println(JAVA);
		System.out.println(JSP);
		System.out.println(ORACLE);
	}
}
