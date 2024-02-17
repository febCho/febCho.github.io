package kr.s21.object.extention;

public class SmartPhone extends Phone{
	private String os;
	
	//생성자
	public SmartPhone(String number, String model, String color, String os) {
		//상속으로 인해 phone 클래스에 있는 멤버변수도 여기 다 있다고 인식하여 this 사용
		this.number = number;
		this.model = model;
		this.color = color;
		this.os = os;
	}
	
	public String getOs() {
		return os;
	}
}
