package kr.s05.operation;

public class WhileMain07 {
	public static void main(String[] args) {
		java.util.Scanner input = new java.util.Scanner(System.in);
		
		long balance = 0L;//잔고, int가 기본값이므로 L 붙여주기
		
		while(true) {//전체 메뉴가 반복되어야 하므로
			System.out.println("=================================");
			System.out.println("1. 예금 | 2. 출금 | 3. 잔고 확인  | 4. 종료");
			System.out.println("=================================");
			
			System.out.print("메뉴 선택> ");
			int num = input.nextInt();
			
			if(num == 1) {//예금
				System.out.print("예금액 > ");
				balance += input.nextLong();
			}else if(num == 2) {//출금
				System.out.print("출금액 > ");
				balance -= input.nextLong();
			}else if(num == 3) {//잔고 확인
				System.out.printf("잔고 : %,d원%n", balance);
			}else if(num == 4) {//종료
				//System.exit(0); 이렇게 반복이 그냥 끝나기 보다는
				System.out.println("프로그램 종료");
				break;//break문으로 반복 빠져나오는 게 더 효율적
			}else {
				System.out.println("잘못 입력하였습니다.");
			}
		}
		input.close();
	}
}
