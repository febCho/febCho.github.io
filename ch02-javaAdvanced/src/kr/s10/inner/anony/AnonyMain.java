package kr.s10.inner.anony;

class Inner6{
	public void disp() {
		System.out.println("부모 클래스의 disp");
	}
}

public class AnonyMain {
	
	public void make() {
		//익명 내부 클래스
		Inner6 i = new Inner6(){//클래스 영역
			@Override
			public void disp() {//부모 클래스 메서드보다 강력한 재정의 메서드
				System.out.println("자식 클래스의 disp");
			}
		};
		//메서드 호출
		i.disp();
	}
	
	public static void main(String[] args) {
		AnonyMain an = new AnonyMain();
		an.make();
	}

}
