package kr.s10.object.method;

class Tv{
	//Tv의 속성(멤버 변수)
	boolean power; //전원 상태(on/off)
	int channel; //채널
	
	//Tv의 동작(멤버 메서드)
	public void isPower() {
		power = !power;
	}
	
	public void channelUp() {
		++channel;
	}

	public void channelDown() {
		--channel;
	}
	//반환하지 않고 멤버변수의 값을 (내부에서) 변경하는 것
}
public class TvMain {
	public static void main(String[] args) {
		Tv t = new Tv();
		t.isPower(); //기본값이 false, 즉 꺼져 있는 상태이므로 아래와 같이 켜줌
		//인자값이 없으므로 소괄호 안은 비워줌
		//!= w.minof(weight), int result = method.sumof(x);
		
		System.out.println("Tv 실행 여부: " + t.power);
		//채널은 바꾸지 않아 기본값이 출력됨.
		System.out.println("현재 채널: " + t.channel);
		System.out.println("==================");
		
		t.channel = 7; //채널 속성의 값을 변경
		System.out.println("첫번째 변경된 채널: " + t.channel);
		System.out.println("==================");
		
		t.channelDown();
		System.out.println("두번째 변경된 채널: " + t.channel);
		System.out.println("==================");
		
		t.isPower();
		System.out.println("Tv 실행 여부: " + t.power);
		
	}
}
