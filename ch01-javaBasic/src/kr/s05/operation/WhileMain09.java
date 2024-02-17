package kr.s05.operation;

public class WhileMain09 {
	public static void main(String[] args) {
		/*
		 * [실습]
		 * 동전을 넣고 커피를 주문하면 커피를 판매하는 자판기 프로그램
		 * 자판기는 자판기 보유 동전(1000), 커피(10), 프림(10), 설탕(10)을
		 * 보유하고 있고 커피를 주문할 때 마다 자판기 보유 동전 - 거스름돈,
		 * 커피 5 차감, 프림 3 차감, 설탕 1 차감, 0이 되면 판매를 중단 함.
		 * 
		 * [입력 및 출력 예시]
		 * 동전을 넣으세요(커피값: 400원): 500 //구매 동전은 보유 동전에 쌓이지 X
		 * 
		 * 거스름돈 : 100원
		 * 맛 좋은 커피가 준비되었습니다.
		 * ==========현재 자판기 정보============
		 * 커피양: 5
		 * 프림양: 7
		 * 설탕양: 1
		 * 자판기 보유 동전 금액: 900원
		 * 투입한 동전 금액: 500원
		 * ==================================
		 * 
		 * or
		 * 동전을 넣으세요(커피값: 400원): 300
		 * (고객이 투입한 동전이 커피값보다 작으면) 투입한 동전이 부족합니다.
		 * 
		 * or
		 * 동전을 넣으세요(커피값: 400원): 1000
		 * (커피가 부족하면) 커피가 부족합니다.
		 * (프림이 부족하면) 프림이 부족합니다.
		 * (설탕이 부족하면) 설탕이 부족합니다.
		 * (자판기 보유 동전이 부족하면) 거스름돈이 부족합니다.
		 * 
		 */
		
		//커피 정보
		int price = 400;
		//커피 한 잔에 들어갈 재료의 양
		int content_coffee = 5;
		int content_cream = 3;
		int content_sugar = 1;
		
		//커피에 들어갈 재료의 현재 보유량
		int coffee = 10;
		int cream = 10;
		int sugar = 10;
		
		//투입한 금액 누적
		int amount = 0;
		//자판기 보유 동전
		int coin = 1000;
		
		java.util.Scanner input = new java.util.Scanner(System.in);
		
		while(true){
			System.out.print("1. 커피 마시기, 2: 종료> ");
			int num = input.nextInt();//자판기 메뉴 번호
			if(num == 1) {
				System.out.print("동전을 넣으세요(커피값 " + price + "원): ");
				int money = input.nextInt();//내가 지불한 돈
				
				//거스름돈 계산
				int change = money - price;
				
				if(coffee < content_coffee) {
					System.out.println("커피가 부족합니다.");
					continue;
				}
				
				else if(cream < content_coffee) {
					System.out.println("프림이 부족합니다.");
					continue;
				}
				
				else if(sugar < content_sugar) {
					System.out.println("설탕이 부족합니다.");
					continue;
				}
				
				else if(coin < change){
					System.out.println("거스름돈이 부족합니다.");
					continue;
				}
				
				else if(money < price) {
					System.out.println("투입한 동전이 부족합니다.");	
					continue;
				}
				
				//위의 모든 조건이 false가 되어 정상 주문되었을 경우 - 차감
				coffee -= content_coffee;
				cream -= content_cream;
				sugar -= content_sugar;
				coin -= change;
				//정상 주문되었을 경우 - 누적
				amount += money;
				
				System.out.printf("거스름돈: %,d원%n", change);
				System.out.println("맛 좋은 커피가 준비되었습니다.");
				
				System.out.println("======현재 자판기 정보======");
				System.out.printf("커피양: %d%n", coffee);
				System.out.printf("프림양: %d%n", cream);
				System.out.printf("설탕양: %d%n", sugar);
				System.out.printf("자판기 보유 동전 금액: %,d원%n", coin);
				System.out.printf("투입한 동전 금액: %,d원%n", amount);
				System.out.println("=======================");
			}
			else if(num == 2) {
				System.out.println("자판기 프로그램 종료");
				break;
			}
			else {
				System.out.println("잘못 입력했습니다.");
			}
		}
		input.close();
	
	}
}
