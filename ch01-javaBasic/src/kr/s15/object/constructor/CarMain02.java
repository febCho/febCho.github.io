package kr.s15.object.constructor;

class Car2{
	String color;
	String gearType;
	int door;
	
	//생성자 오버로딩
	public Car2() {}
	
	public Car2(String c, String g, int d) {
		color = c;
		gearType = g;
		door = d;
	}
}
public class CarMain02 {
	public static void main(String[] args) {
		Car2 c1 = new Car2();
		//객체 생성 시, 다른 생성자가 있는 경우
		//컴파일러가 기본 생성자를 자동으로 만들어 주지 않으므로
		//별도로 꼭 작성해 주어야 한다는 점 주의할 것
		
		c1.color = "white";
		c1.gearType = "auto";
		c1.door = 4;
		
		System.out.println(c1.color + "," + c1.gearType + "," + c1.door);
		
		//인자가 있는 생성자로 출력하기
		Car2 c2 = new Car2("black", "manual", 2);
		System.out.println(c2.color + "," + c2.gearType + "," + c2.door);
	}
}
