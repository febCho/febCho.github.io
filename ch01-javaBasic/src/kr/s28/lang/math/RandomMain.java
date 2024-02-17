package kr.s28.lang.math;

import java.util.Random;

public class RandomMain {
	public static void main(String[] args) {
		//배열 선언 및 생성, 초기화
		String[] gift = {"스마트폰", "TV", "냉장고", "꽝!"};
		                //   0      1      2     3
		double ran = Math.random();//0.0 ~ 1.0 "미만의" 난수 발생
		System.out.println("발생한 난수: " + ran);
		
		//곱하기 4 -> int로 강제 형변환 하여 소수점 자리 절삭
		int index = (int)(ran*4);//0~3
		System.out.println("정수로 변환한 난수: " + index);
		System.out.println("오늘의 선물: " + gift[index]);
		
		System.out.println("==========================");
		
		//랜덤 클래스를 이용, 랜덤 클래스가 가지고 있는 메서드 중
		//정수를 반환하는 메서드를 활용하기
		String[] luck = {"귀인을 만남", "해외여행 출발", "로또 당첨", "피곤한 하루"};
		                //    0          1          2          3
		Random r1 = new Random();
		
		index = r1.nextInt(4);//0부터 인자로 전달된 값 전까지의 범위로 난수 발생(0~3)
		System.out.println("발생한 난수: " + index);
		System.out.println("오늘의 운세: " + luck[index]);
		
	}
}
