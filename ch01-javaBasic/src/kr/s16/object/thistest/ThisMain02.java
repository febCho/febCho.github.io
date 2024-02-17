package kr.s16.object.thistest;

class ThisTest{
	//은닉화
	private int a;//멤버 변수
	
	//캡슐화
	public void setA(int a) {//int n은 메서드 안에만 있는 '지역 변수'
		//메서드 내에서 지역 변수 명을 멤버 변수 명과 동일하게 사용하면
		//지역 변수가 우선하기 때문에 멤버 변수 명을 인식하지 못한다.
		//세 개 다 지역변수가 되지 않도록 this를 붙여 멤버 변수 임을 구별
		this.a = a;
	}
	public int getA() {
		return a;
	}
}
public class ThisMain02 {
	public static void main(String[] args) {
		ThisTest tt = new ThisTest();
		tt.setA(10);
		System.out.println(tt.getA());
	}
}
