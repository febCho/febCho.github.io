package kr.s08.inner.local;

public class LocalMain02 {
	//멤버 메서드
	public void innerTest(int a) {
		//a가 지역변수에서 자동으로 상수화 되기 때문에
		//값을 변경할 수 없음
		//a = 500;
			
		int b = 200;
		//b가 지역변수에서 자동으로 상수화 되기 때문에
		//값을 변경할 수 없음
		//b = 10;
			
		//로컬 내부 클래스
		//로컬 내부 클래스가 포함된 메서드의 지역변수를 로컬 내부 클래스에서
		//가져다 쓰게 하기 위해 지역변수를 상수화 함.
		//따라서 상수화 된 값은 변경 불가능
		class Inner{
			public void getData() {
				System.out.println("a: " + a);
				System.out.println("b: " + b);
					
				//상수화 되어 변경 불가능
				//a = 100;
				//b = 200;
			}
		}
		//로컬 내부 클래스 객체 생성
		Inner i = new Inner();
		i.getData();
	}
	public static void main(String[] args) {
		LocalMain02 lo = new LocalMain02();
		lo.innerTest(70);
	}
}
