package kr.s14.object.capsule;

class Capsule{
	//private은 같은 클래스 내에서만 접근 가능
	//<은닉화>
	private int a;
	
	//캡슐화 - 대신 접근해 줄 수 있는 메서드 만들기
	public void setA(int n) {
		if(n >= 0) {
			a = n; //자연수면 a에 n 대입
		}else {
			System.out.println("음수는 허용되지 않습니다.");
			//음수일 경우에는 대입하는 대신 위 문구를 출력하여 알려줌
		}
	}
	public int getA() {//인자값이 빈 이유는 같은 클래스 내 int a를 쓸 거니까
		return a;//CapsuleMain 클래스에서 a를 직접적으로 출력할 수도 없으니
		         //getA 메서드를 활용해 값을 반환하는 형태로 출력하게 함
	}
}
public class CapsuleMain {
	public static void main(String[] args) {
		Capsule cap = new Capsule();
		//변수 a의 접근 지정자(제한자)가 private이기 때문에
		//같은 클래스 내에서는 호출이 가능하지만
		//다른 클래스에서는 호출이 불가능
		//cap.a = 10; - default가 접근 지정자일 경우에는
		//위 데이터를 =10으로 바꾸어도 출력됨. 즉 아무렇게나 바꿀 수 있음.
		//System.out.println(cap.a);
		
		cap.setA(100);
		System.out.println(cap.getA());//데이터 호출
		
		cap.setA(-100);
		System.out.println(cap.getA());
	}
}
