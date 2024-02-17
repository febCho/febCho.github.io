package kr.s24.object5.abs;

/*
 * 추상클래스
 * 미완성된 개념으로 단독으로 객체 생성이 불가능하고 일반적으로 자식클래스에 상속되어져 사용함.
 * (단독으로 메모리에 올릴 수 없음)
 */

abstract class A{
	private int x;
	public void setX(int x) {
		this.x = x;
	}
	public int getX() {
		return x;
	}
}

class B extends A{
	int b = 200;
}

public class AbstractMain01 {
	public static void main(String[] args) {
		//추상클래스는 객체 생성 불가능
		//A ap = new A();
		
		B bp = new B();
		bp.setX(100);
		System.out.println(bp.getX());
		System.out.println(bp.b);
	}
}
