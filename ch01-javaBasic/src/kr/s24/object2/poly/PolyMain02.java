package kr.s24.object2.poly;

//부모 클래스
class A{
	public void make() {
		System.out.println("make 메서드");
	}
}
//자식 클래스
class B extends A{
	public void play() {
		System.out.println("play 메서드");
	}
}

public class PolyMain02 {
	public static void main(String[] args) {
		B bp = new B();
		bp.make();
		bp.play();
		
		//업캐스팅: 자식 > 부모 자동 형변환
		A ap = bp;
		ap.make();
		//ap.play(); -> 호출 범위를 벗어나 호출 불가능
		
		//다운캐스팅: 부모 > 자식 명시적 형변환
		B bp2 = (B)ap;
		bp2.make();
		bp2.play();
	}
}
