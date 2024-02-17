package kr.s23.object.bank;

public class BankMain {
	public static void main(String[] args) {
		//일반 계좌 생성
		BankAccount bank = new BankAccount("100-123", "1234", "홍길동", 10000L);
		
		//계좌 정보 출력
		bank.printAccount();
		//입금하기
		bank.deposit(2000L);
		//계좌 정보 출력
		bank.printAccount();
		//출금 하기
		bank.withdraw(12000L);
		//계좌 정보 출력
		bank.printAccount();
		
		System.out.println("=======================");
		
		//마이너스 계좌 생성
		MinusAccount ma = new MinusAccount("123-101", "5432", "박문수", 10000L, 1000L);
		
		//마이너스 계좌 정보 출력
		ma.printAccount();
		//입금하기
		ma.deposit(10000L);
		//마이너스 계좌 정보 출력
		ma.printAccount();
		//출금 하기
		ma.withdraw(21000L);
		//마이너스 계좌 정보 출력
		ma.printAccount();
	}
}
