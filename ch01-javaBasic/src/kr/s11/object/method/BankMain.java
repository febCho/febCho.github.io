package kr.s11.object.method;

/*
 * [실습]
 * Account
 * 1)멤버 변수: 계좌번호(account_num), 예금주(name), 잔고(balance)
 * 2)멤버 메서드: 1. 예금하기(deposit) : balance에 값 누적
 *                예금 처리 후 "입금이 완료되었습니다." 문구 출력
 *             2. 출금하기(withdraw) : balance에 값 차감
 *                출금 처리 후 "출금이 완료되었습니다." 문구 출력
 *             3. 계좌정보(printAccount) : 계좌번호, 예금주, 잔고 출력
 *             
 * BankMain
 * 1) Account 생성
 *    "계좌 기본 정보를 입력해서 계좌를 생성합니다." 문구 출력 후
 *    계좌번호, 예금주, 잔고를 입력
 *    "홍길동님 계좌가 개설되었습니다." 문구 출력
 * 2)while문을 만들고 메뉴 지정
 *   1. 예금, 2. 출금 3. 잔고 확인, 4. 종료
 */

import java.util.Scanner;

class Account{
	String account_num;
	String name;
	int balance;
	
	public void deposit(int m) {
		if(m > 0){
			balance += m;
			System.out.println("입금이 완료되었습니다.");
		}else {
			System.out.println("0보다 큰 값을 입금해야 합니다.");
		}
	}
	
	public void withdraw(int m) {
		if(m <= 0) {
			System.out.println("0보다 큰 값을 출금해야 합니다.");
		}else if(balance < m) {//잔액보다 출금하려는 금액이 많음
			System.out.println("잔액이 부족합니다.");
		}else {
			balance -= m;
			System.out.println("출금이 완료되었습니다.");
		}
	}
	
	public void printAccount() {
		System.out.println("계좌번호: " + account_num);
		System.out.println("예금주: " + name);
		System.out.printf("잔고: %,d원%n", balance);
	}
}
public class BankMain {
	public static void main(String[] args) {
		Account account = new Account();
		Scanner input = new Scanner(System.in);
		
		System.out.println("계좌 기본 정보를 입력해서 계좌를 생성합니다.");
		System.out.print("계좌번호: ");
		account.account_num = input.nextLine();
		System.out.print("예금주: ");
		account.name = input.nextLine();
		System.out.print("잔고: ");
		account.balance = input.nextInt();
		
		System.out.println(account.name + "님 계좌가 개설되었습니다.");
		
		while(true) {
			System.out.println("===========================");
			System.out.println("1. 예금 | 2. 출금 | 3. 잔고 확인 | 4. 종료");
			System.out.println("===========================");
			
			System.out.print("메뉴 선택> ");
			int num = input.nextInt();
			
			if(num == 1) {
				System.out.print("예금액> ");
				account.deposit(input.nextInt());
			}else if(num == 2) {
				System.out.print("출금액> ");
				account.withdraw(input.nextInt());
			}else if(num == 3) {
				account.printAccount();
			}else if(num == 4) {
				System.out.println("프로그램 종료");
				break;
			}else {
				System.out.println("잘못 입력하였습니다.");
			}
		}
		input.close();
	}
}
