package kr.s02.collections.list2;

public class Product {
	//멤버 변수
	private String name;//상품명
	private int price;//상품 가격
	private String num;//상품번호
	private String maker;//제조사
	private int stock;//재고 수량
	
	//생성자
	public Product() {}

	public Product(String name, int price, String num, String maker, int stock) {
		super();
		this.name = name;
		this.price = price;
		this.num = num;
		this.maker = maker;
		this.stock = stock;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
}
