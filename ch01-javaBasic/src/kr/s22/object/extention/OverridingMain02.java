package kr.s22.object.extention;

//부모 클래스
class Mother{
	public String getLunch() {
		return "밥";
	}
}
//자식 클래스
class Son extends Mother{
	
}
//자식 클래스
class Daughther extends Mother{
	//@Override 어노테이션은 메서드 재정의 문법에 맞게 재정의가 되었는지 검증.
	//문법에 맞게 재정의 되지 않으면 컴파일 오류가 발생
	@Override
	public String getLunch() {
		return "빵";
	}
	
}

public class OverridingMain02 {
	public static void main(String[] args) {
		Son s = new Son();
		System.out.println("아들은 " + s.getLunch() + "을 먹는다");
		
		Daughther d = new Daughther();
		System.out.println("딸은 " + d.getLunch() + "을 먹는다");
	}
}
