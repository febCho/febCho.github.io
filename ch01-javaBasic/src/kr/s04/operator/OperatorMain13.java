package kr.s04.operator;

public class OperatorMain13 {
	public static void main(String[] args) {
		/*
		 *[숙제]
		 * A전자대리점에서는 그날 물건 판매액의 15%를 할인
		 * 해주시기로 했습니다. 판매한 상품명과 상품의 단가와
		 * 수량을 입력해서 지불 금액을 출력하는 프로그램을 작성하시오.
		 * (단, 출력 시에는 소수점 이하 절삭)
		 * 
		 *[입력 예시]
		 * 상품명 입력 : 냉장고
		 * 단가 입력 : 50000
		 * 판매 수량 입력 : 3
		 * 
		 * [출력 예시]
		 * 냉장고 3대 가격은 1,275,000원
		 */
		
		java.util.Scanner input = new java.util.Scanner(System.in);
		
		System.out.print("상품명 입력 : ");
		String mer = input.nextLine();
		
		System.out.print("단가 입력 : ");
		int price = input.nextInt();
		
		System.out.print("판매 수량 입력 : ");
		int count = input.nextInt();
		
		int result = (int)(price * 0.85f) * count;
		//int result = (int)(price * 0.85f * count);도 가능
		//int result = price*count*85/100;도 가능하며, 이땐 손실이 없다.
		
		System.out.printf("%s %d대 가격은 %,d원", mer, count, result);
		
		input.close();
	}
}
