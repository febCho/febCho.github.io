package kr.s17.object.trainning;

public class AnimalMain {
	/*
	 * [실습]
	 * 1. 객체 생성 : 인자가 있는 생성자로 객체 생성
	 * 2. 생성된 객체의 멤버 변수에 저장된 정보 출력
	 *    이름 : 기러기
	 *    나이 : 3살
	 *    비행 여부 : 가능
	 * 3. 객체 생성 : 인자가 없는 생성자로 객체 생성
	 * 4. 이름, 나이, 비행 여부를 저장
	 * 5. 생성된 객체의 멤버 변수에 저장된 정보 출력
	 *    이름 : 기린
	 *    나이 : 10살
	 *    비행 여부 : 불가능
	 */
	
	public static void main(String[] args) {
		Animal am = new Animal("독수리", 3, true);
		
		System.out.println("이름: " + am.getName());
		System.out.println("나이: " + am.getAge() + "살");
		System.out.println("비행 여부: " + printFly(am.isFly()));
		System.out.println("============");
		
		Animal am2 = new Animal();
		
		am2.setName("말티즈");
		am.setAge(2);
		am.setFly(false);
		
		System.out.println("이름: " + am2.getName());
		System.out.println("나이: " + am.getAge() + "살");
		System.out.println("비행 여부: " + printFly(am2.isFly()));
	}
	public static String printFly(boolean fly) {
		return fly ? "가능" : "불가능";
	}
}
