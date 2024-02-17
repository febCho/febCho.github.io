package kr.s18.object.statictest;

public class StaticCount {
	//인스턴트 변수 : 객체가 생성될 때 객체에 포함되는 변수
		int c;
		//static(클래스) 변수 : 객체가 생성될 때 포함되지 않음
		//즉, 단독으로 메모리에 올라감
		static int count;
		
		//생성자
		public StaticCount() {
			c++;
			count++;
			//생성자를 호출하게 되면 객체 생성 후 1 증가
		}
}
