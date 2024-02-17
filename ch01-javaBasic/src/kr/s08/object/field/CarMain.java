package kr.s08.object.field;

class Car{
	//멤버 변수
	String company = "KG모빌리티";
	String model = "토레스";
	String color = "회색";
	int maxSpeed = 350;
	int speed = 90;
	//원한다면 위와 같이 기본값을 세팅하고 출발할 수 있다.
}
public class CarMain {
	public static void main(String[] args) {
		Car myCar = new Car();
		
		System.out.println("제작회사: " + myCar.company);
		System.out.println("모델명: " + myCar.model);
		System.out.println("색상: " + myCar.color);
		System.out.println("최고속도: " + myCar.maxSpeed);
		System.out.println("현재속도: " + myCar.speed);
		System.out.println("============================");
		
		//멤버 변수의 값 변경
		myCar.speed = 60;
		System.out.println("수정된 속도: " + myCar.speed);
	}
}
