package kr.s05.operation;

public class Ifmain09 {
	public static void main(String[] args) {
		/*
		 * [실습]
		 * 
		 * 생년월일을 입력하고 만 나이를 출력하는 프로그램을 작성하시오.
		 * 만 나이 = (현재 연도 - 태어난 연도) - (생일 지났으면 0, 생일 지나지 않았으면 1)
		 * 
		 * [입력 예시]
		 * 출생연도 입력: 2000
		 * 월 입력: 3
		 * 일 입력: 12
		 * 
		 * [출력 예시]
		 * 만 나이는 23
		 * 
		 */
		
		//현재 날짜 정보
		int thisYear = 2023;
		int thisMonth = 9;
		int thisDate = 4;
		
		java.util.Scanner input = new java.util.Scanner(System.in);
		
		System.out.print("출생연도 입력: ");
		int year = input.nextInt();
		
		System.out.print("월 입력: ");
		int month = input.nextInt();
		
		System.out.print("일 입력: ");
		int date = input.nextInt();
		
		//만 나이 구하기
		int age = thisYear - year;
		
		//생일이 안 지난 경우 - 먼저 월 비교
		if(month > thisMonth) {
			age--;
		//생일이 안 지난 경우 - 월이 같으면 일 비교
		}else if(month == thisMonth && date > thisDate) {
			age--;
		}//월도 현재보다 작고, 일도 현재보다 작다면 생일 지난 것
		//이 경우에는 그냥 -0이므로 else에 굳이 조건 적을 필요 없음
		System.out.printf("만 나이는 %d%n", age);
		
		input.close();
	}
}
