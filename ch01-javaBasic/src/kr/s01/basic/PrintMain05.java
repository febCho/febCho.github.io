package kr.s01.basic;

public class PrintMain05 {
	public static void main(String[] args) {
		//System.out.printf(포맷문자, 데이터)를 이용한 출력
		//(데이터의 종류를 표시할 수 있는 포맷문자 지원)
		
		//문자
		System.out.printf("%c%n", 'A');
		System.out.printf("%6c%n", 'B');//6자리 확보, 오른쪽에 정렬
		System.out.printf("%-6c%n", 'C');//6자리 확보, 왼쪽에 정렬
		System.out.println("==============");
		
		//정수
		System.out.printf("%d%n", 67);
		System.out.printf("%6d%n", 8);//5자리 확보, 오른쪽에 정렬
		System.out.printf("%-5d%n", 3);//5자리 확보, 왼쪽에 정렬
		System.out.printf("%,d원%n", 10000);//3자리 단위로 쉼표 표시
		System.out.println("===========");
		
		//실수
		System.out.printf("%f%n", 35.896);//소수점 6자리 확보, 비어 있는 자리는 0으로 채움
		System.out.printf("%.2f%n", 35.896);//소수점 둘째자리까지 출력
		System.out.printf("%10.2f%n", 35.896);//10자리를 확보하고 오른쪽부텨 표시, 소수점 둘째자리까지 출력
		System.out.println("=============");
		
		//문자열
		System.out.printf("%s%n", "우주");
		System.out.println("===========");
		
		//논리값
		System.out.printf("%b%n", true);
		System.out.println("============");
		
		//데이터의 종류가 여러 개일 경우
		System.out.printf("%s는 %d점입니다", "점수", 98);
	}
}
