package kr.s24.object2.poly;

//부모 클래스
class Product{
	int price; //제품 가격
	int bonusPoint;//제품 구매 시 제공하는 보너스 점수
	
	//인자가 있는 생성자
	public Product(int price) {
		this.price = price;
		bonusPoint = price/10;
	}
	
	//제품의 이름을 반환하는 메서드
	public String getName() {
		return "상품";
	}
}

class Tv extends Product{
	public Tv() {//Tv의 가격 세팅
		super(100);//Product의 생성자
	}
	//메서드 오버라이딩(재정의)
	@Override
	public String getName() {
		return "Tv";
	}
}

class Computer extends Product{
	public Computer() {//컴퓨터의 가격 세팅
		super(200);//Product의 생성자
	}
	//메서드 오버라이딩(재정의)
	@Override
	public String getName() {
		return "컴퓨터";
	}
}

class Audio extends Product{
	public Audio() {//오디오의 가격 세팅
		super(300);
	}
	//메서드 오버라이딩(재정의)
	@Override
	public String getName() {
		return "오디오";
	}
}

class Buyer{
	private int money = 1000;//구매자 보유 금액
	private int bonusPoint = 0;//보너스 점수
	
	//상품 구매하는 메서드(메서드 오버로딩(중복정의)
	//구매하고자 하는 모든 제품의 buy 메서드를 때마다 만드는 것은 한계가 있다.
	//public void buy(Tv t) {}
	//public void buy(Computer c) {}
	
	//상품 구매
	public void buy(Product p){//tv와 컴퓨터 모두 Product 타입으로 형변환
		if(money < p.price) {
			System.out.println("잔액이 부족하여 물건을 살 수 없습니다.");
			return;
		}
		money -= p.price;//차감
		bonusPoint += p.bonusPoint;//누적
		
		System.out.println(p.getName() + "을/를 구입하셨습니다.");
		System.out.println("현재 남은 돈은 " + money + "만 원입니다.");
		System.out.println("현재 보너스 점수는 " + bonusPoint + "점입니다.");
		
	}
}
public class PolyMain04 {
	public static void main(String[] args) {
		Buyer b = new Buyer();
		Tv tv = new Tv();
		Computer com = new Computer();
		Audio au = new Audio();
		
		//Tv 구매
		b.buy(tv);//tv -> Product 업캐스팅, 자동 형변환
		//Product p = tv;
		//컴퓨터 구매
		b.buy(com);//컴퓨터 -> Product 업캐스팅, 자동 형변환
		//Product p = com;
		//오디오 구매
		b.buy(au);//오디오 -> Product 형변환
	}
}
