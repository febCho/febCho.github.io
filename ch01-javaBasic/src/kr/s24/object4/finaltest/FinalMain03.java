package kr.s24.object4.finaltest;

//클래스에 final을 지정하면 상속 불가능
final class Me2{
	int a = 200;
	public void make() {
		System.out.println("make 메서드");
	}
}
public class FinalMain03{
//public class FinalMain03 extends Me2{//final 클래스는 상속 불가능
	public static void main(String[] args) {
		
	}
}
