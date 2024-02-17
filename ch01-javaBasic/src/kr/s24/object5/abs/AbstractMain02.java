package kr.s24.object5.abs;

//추상 클래스
abstract class A2{
	int x = 100;
	//추상 클래스는 일반적으로 하나 이상의 추상 메서드를 포함
	//추상 메서드
	public abstract void make();
	//멤버 메서드
	public void play() {
		System.out.println("play 메서드");
	}
}

class B2 extends A2{
	//추상 클래스를 상속 받으면 추상 클래스의 추상 메서드를
	//자식 클래스에 반드시 구현해야 객체 생성이 가능함
	@Override
	public void make() {
		System.out.println("make 메서드");
	}
}

public class AbstractMain02 {
	public static void main(String[] args) {
		B2 bp = new B2();
		bp.make();
	}
}
