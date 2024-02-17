package kr.s11.enumtest;

enum Gender{
	MALE, FEMALE;
	
	//Object의 toString 메서드 재정의
	@Override
	public String toString() {
		switch(this) {//this: 자기 자신을 객체로 받는다 = MALE, FEMALE
		case MALE:
			return "남자";
		default: //case FEMALE: 이라고 써도 됨
			return "여자";
		}
	}
}
public class EnumMain04 {
	public static void main(String[] args) {
		System.out.println(Gender.MALE);//toString이 생략되어 있는 것
		System.out.println(Gender.FEMALE);
		System.out.println("==================");
		
		System.out.println(Gender.MALE.toString());
		System.out.println(Gender.FEMALE.toString());
	}
}
