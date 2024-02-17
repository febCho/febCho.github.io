package kr.s17.object.trainning;

public class Animal {
	/*
	 * [실습]
	 * 1. 멤버 변수: 이름(name), 나이(age), 비행 여부(fly)
	 * 2. 생성자 지정: 인자 없는 생성자, 인자가 있는 생성(name, age, fly)
	 * 3. set/get 지정 : 멤버 변수를 private으로 지정하고 public한 set/get 메서드 정의
	 */
	
	private String name;
	private int age;
	private boolean fly;
	
	public Animal() {}
	
	public Animal(String name, int age, boolean fly) {
		this.name = name;
		this.age = age;
		this.fly = fly;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isFly() {
		return fly;
	}

	public void setFly(boolean fly) {
		this.fly = fly;
	}
	
}
