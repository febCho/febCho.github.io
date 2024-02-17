package kr.spring.product;

public class Product {
	//핵심 기능 수행
	public String launch() {
		System.out.println("launch() 메서드 출력");
		//예외 발생 시 호출되는 공통 기능을 테스트하기 위해
		//System.out.println(20/0);
		return "[상품 출시]";
	}
}
