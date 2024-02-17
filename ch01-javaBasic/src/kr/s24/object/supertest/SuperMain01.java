package kr.s24.object.supertest;

class Mother{
	public String getLunch() {
		return "밥";
	}
}

class Daugther extends Mother{
	//메서드 오버라이딩(재정의)
	@Override
	public String getLunch() {
		return "빵";
	}
	
	public String getRice() {
		//부모 클래스의 getLunch 메서드 호출
		return super.getLunch();
	}
}
public class SuperMain01 {
	public static void main(String[] args) {
		Daugther d = new Daugther();
		System.out.println("딸은 " + d.getLunch() + "을 먹습니다.");
		System.out.println("딸은 오늘은 왠지 " + d.getRice() + "이 먹고 싶습니다.");
	}

}
