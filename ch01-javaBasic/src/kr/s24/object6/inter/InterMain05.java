package kr.s24.object6.inter;

interface Inter1{
	public int getA();
}
interface Inter2{
	public int getB();
}
//인터페이스 간 다중 상속
interface Inter3 extends Inter1, Inter2{
	public int getData();
}
interface Inter4{
	public int getC();
}

//클래스에 인터페이스를 다중 구현
public class InterMain05 implements Inter3, Inter4 {
	@Override
	public int getA() {
		return 10;
	}
	@Override
	public int getB() {
		return 20;
	}
	@Override
	public int getData() {
		return 30;
	}
	@Override
	public int getC() {
		return 40;
	}
	
	public static void main(String[] args) {
		InterMain05 in = new InterMain05();
		System.out.println(in.getA());
		System.out.println(in.getB());
		System.out.println(in.getData());
		System.out.println(in.getC());
	}
}
