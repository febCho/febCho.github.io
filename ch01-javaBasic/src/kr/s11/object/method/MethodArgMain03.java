package kr.s11.object.method;

public class MethodArgMain03 {
	//Variable Arguments
	//자료형이 일치할 때 전달하고자 하는 값의 개수를 다르게 지정할 수 있음.
	//전달하는 데이터는 내부적으로 배열로 인식함.
	
	public void argTest(int ... n) {//n은 배열의 주소
		for(int i=0;i<n.length;i++) {
			System.out.println("n[" + i + "]:" + n[i]);
		}
		System.out.println("===============");
	}
	public static void main(String[] args) {
		MethodArgMain03 me = new MethodArgMain03();
		//me.argTest(10, 20); n=10, m=20 / argTest(int n, int m)
		                    //원래는 이렇게 메서드에 기입한 인자 개수와 일치해야 함
		
		me.argTest(); //배열이 생성은 되지만, 전달된 데이터가 없어
		              //방이 만들어지지 않았음 = n.length가 0이라
		              //for이 루프를 돌지 않고 아래의 구분선만 출력
		me.argTest(10);
		me.argTest(10,20);
		me.argTest(10,20,30);
	}
}
