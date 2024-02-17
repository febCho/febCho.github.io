package kr.s16.object.thistest;

public class ThisMain01 {
	/*
	 * this는 객체 내부에서 객체를 지칭할 때 사용할 수 있고 일종의 참조변수 역할을 함
	 * 객체의 구성원(필드, 메서드)을 호출할 때 사용
	 */
	
	//생성자
	public ThisMain01() {
		System.out.println("객체 생성: " + this);
		//객체가 생성되는 시점에 this 출력
	}
	
	public static void main(String[] args) {
		ThisMain01 tm = new ThisMain01();
		System.out.println("객체 생성 후: " + tm);
		
	}
}
