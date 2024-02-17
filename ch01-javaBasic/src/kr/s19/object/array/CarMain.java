package kr.s19.object.array;

class Car{
	//멤버 변수
	private String color;
	private int speed;
	
	//생성자 안 만들어줘서 기본 생성자 컴파일러가 만듦.
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
}
public class CarMain {
	public static void main(String[] args) {
		//배열 선언 및 생성 = 배열도 하나의 객체
		Car[] carArray = new Car[3];
		
		for(int i=0;i<carArray.length;i++) {//null
			//null의 의미: 객체가 생성되지 않아 참조할 주소가 없다는 뜻
			System.out.println(carArray[i]);
		}
		System.out.println("=============");
		
		carArray[0] = new Car();//객체 주소 저장
		carArray[0].setColor("검정색");
		carArray[0].setSpeed(100);
		
		carArray[1] = new Car();//객체 주소 저장
		carArray[1].setColor("흰색");
		carArray[1].setSpeed(200);
		
		carArray[2] = new Car();//객체 주소 저장
		carArray[2].setColor("파란색");
		carArray[2].setSpeed(300);
		
		//배열의 요소 출력
		for(int i=0;i<carArray.length;i++) {//객체의 주소 출력
			//carArray라는 배열에 heap 영역에 만들어진 car라는 객체의 주소가 각각 저장되어 있다.
			System.out.println(carArray[i]);
		}
		System.out.println("=================");
		
		//Car 객체의 멤버 변수에 저장된 데이터를 출력
		for(int i=0;i<carArray.length;i++) {
			System.out.println("carArray[" + i + "]: 색상->" +
		      carArray[i].getColor() + ", 스피드->" + carArray[i].getSpeed());
		}
		System.out.println("===================");
		
		//전통적인 for문보다 확장 for문이 훨씬 간단하다.
		for(Car car : carArray) {
			System.out.println("색상: " + car.getColor() +
					           ", 스피드: " + car.getSpeed());
		}
	}

}
