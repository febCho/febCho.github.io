package kr.s24.object5.abs;

//부모 클래스
abstract class Animal{
	public void breathe() {
		System.out.println("숨을 쉬다");
	}
	//추상 메서드
	public abstract void sound();
}

//자식 클래스
class Dog extends Animal{
	//추상 메서드 구현
	@Override
	public void sound() {
		System.out.println("개는 멍멍멍");
	}
}

class Cat extends Animal{
	//추상 메서드 구현
	@Override
	public void sound() {
		System.out.println("고양이는 야옹");
	}
}

public class AbstractMain03 {
	public static void main(String[] args) {
		Dog d = new Dog();
		d.breathe();
		d.sound();
		System.out.println("==========");
		Cat c = new Cat();
		c.breathe();
		c.sound();
	}
}
