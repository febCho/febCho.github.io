package kr.s21.object.extention;

public class FeaturePhone extends Phone{
	private int pixel; //사진 화소수
	
	public FeaturePhone(String number, String model, String color, int pixel) {
		this.number = number;
		this.model = model;
		this.color = color;
		this.pixel = pixel;
	}
	public int getPixel() {
		return pixel;
	}
}
