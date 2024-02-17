package kr.s11.object.method;

public class MethodArgMain02 {
	//인자 전달 방식: 참조 호출(call by reference)
	//객체의 주소를 인자로 전달하는 방식. 주소(reference)를 복사하여 전달
	public void increase(int[] n) {
		for(int i=0;i<n.length;i++) {
			n[i]++;//i가 인덱스 역할, 해당 인덱스에 접근하여 1씩 증가시켜 줌
		}
	}
	
	public static void main(String[] args) {
		int[] ref1 = {100, 200, 300};
		System.out.println("===배열 정보를 객체의 메서드에 보내기 전===");
		for(int i=0;i<ref1.length;i++) {
			System.out.println("ref1[" + i + "]:" + ref1[i]);
		}
		
		//객체 선언 및 생성
		MethodArgMain02 me = new MethodArgMain02();
		//ref1 배열의 주소를 복사해서 메서드의 인자로 전달
		me.increase(ref1);//ref1을 n에 복사해 줬으므로 둘 다 같은 주소를 가리키게 됨
		
		System.out.println("===배열 정보를 객체의 메서드에 보낸 후===");
		for(int i=0;i<ref1.length;i++) {
			System.out.println("ref1[" + i + "]:" + ref1[i]);
	}
}
}