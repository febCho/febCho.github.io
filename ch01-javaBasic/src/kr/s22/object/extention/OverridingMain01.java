package kr.s22.object.extention;

//부모 클래스
class GrandParent{
	public String getCar() {
		return "구형 자동차";
	}
}

//자식 클래스
class Father extends GrandParent{
	/*
	 * Method Overriding, 메서드 재정의
	 * 상속 관계에서 자식 클래스에 메서드를 재정의를 하면
	 * 부모 클래스의 메서드가 호출되는 것이 아니라 자식 클래스의 메서드가 호출됨
	 */
	public String getCar() {
		return "신형 자동차";
	}

}

class Uncle extends GrandParent{
	
}
public class OverridingMain01 {
	public static void main(String[] args) {
		Father ft = new Father();
		System.out.println(ft.getCar());
		
		Uncle uc = new Uncle();
		System.out.println(uc.getCar());
	}
}
