package kr.s08.inner.local;

public class LocalMain01 {
	
	//멤버 메서드
		public void innerTest() {
		//로컬 내부 클래스
			class Inner{
			public void getData() {
				System.out.println("Local 내부 클래스");
			}
		}
		//로컬 내부 클래스 객체 생성
		Inner i = new Inner();
		i.getData();
}
			
	public static void main(String[] args) {
		LocalMain01 lo = new LocalMain01();
		lo.innerTest();
	}
}
