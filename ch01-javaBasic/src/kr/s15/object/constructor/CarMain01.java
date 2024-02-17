package kr.s15.object.constructor;

class Car{
	//멤버 변수
	String color;
	String gearType;
	int door;
	
	//기본 생성자 - 생략 가능
	public Car() {}
	
}
public class CarMain01 {
	public static void main(String[] args) {
		//객체 선언 및 생성
		//생성자는 객체 생성 시 단 한 번 실행되고
		//객체 생성 이후에는 호출 불가능
		//또한, 멤버 변수를 초기화 하는 역할 수행
		Car c1 = new Car();
		System.out.println(c1.color + "," + c1.gearType + "," + c1.door);
		
		//멤버 변수의 데이터 변경
		c1.color = "white";
		c1.gearType = "auto";
		c1.door = 4;
		
		System.out.println(c1.color + "," + c1.gearType + "," + c1.door);
	}
}
