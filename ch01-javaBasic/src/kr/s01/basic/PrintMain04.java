package kr.s01.basic;

public class PrintMain04 {
	public static void main(String[] args) {
		/*
		 *[실습]
		 *철수는 학교에서 성적표를 아래와 같이 받았습니다.
		 *내용을 출력하시오. (점수는 숫자로 명시, true는 논리값으로 표시)
		 *
		 *(출력 예시)
		 *
		 *성적표
		 *===============
		 *이름 : 철수
		 *국어 : 89
		 *영어 : 70
		 *수학 : 95
		 *총점 : 254
		 *평균 : 84.67
		 *통과 여부 : true
		 */
		
		System.out.println("성적표");
		System.out.println("=========");
		System.out.println("이름 : 철수");
		System.out.print("국어 : ");
		System.out.println(89);
		System.out.print("영어 : ");
		System.out.println(70);
		System.out.print("수학 : ");
		System.out.println(95);
		System.out.print("총점 : ");
		System.out.println(254);
		System.out.print("평균 : ");
		System.out.println(84.67);
		System.out.print("통과 여부 : ");
		System.out.println(true);
	}
}
