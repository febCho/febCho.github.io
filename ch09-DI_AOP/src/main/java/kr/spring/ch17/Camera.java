package kr.spring.ch17;

public class Camera {
	public int number;

	public void setNumber(int number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "Camera [number=" + number + "]";
	}
}
