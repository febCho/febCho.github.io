package kr.s20.object.extention;

//부모 클래스
class Parent extends Object{//기본적으로 생략, 자동으로 Object 상속됨
	int a = 100;
}

//자식 클래스
class Child extends Parent{
	int b = 200;
}

public class ExtentionMain01 {
	public static void main(String[] args) {
		//객체 선언 및 생성
		Child ch = new Child();
		System.out.println(ch.a);//상속 관계에 의해 메모리에 업로드, 호출 가능
		System.out.println(ch.b);
	}
}
