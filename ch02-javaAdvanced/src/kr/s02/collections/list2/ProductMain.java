package kr.s02.collections.list2;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class ProductMain {
	//선언만 하고 생성은 아래 ProductMain 생성자 안에 있음
	//(일종의) 멤버 변수
	ArrayList<Product> list;
	BufferedReader br;
	
	//길어 보이지만, 인자 없는 기본 생성자
	public ProductMain() {//메인 부담을 덜기 위해 생성자가 길어진 것
		list = new ArrayList<Product>();
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			callMenu();
		}catch(Exception e) {
			e.printStackTrace();//콘솔에 에러 문구 출력
		}finally {//br 객체를 close 할 때도 IOException이 발생할 수 있음
			if(br!=null)try {br.close();}catch(IOException e) {}
		}
	}
	
	//메뉴 호출(메서드)
	public void callMenu() throws IOException{
		while(true) {
			System.out.print("1. 상품 입력, 2. 상품 목록 보기, 3. 종료> ");
			try {//readLine은 String 타입만 받기 때문에 변환 필요
				int num = Integer.parseInt(br.readLine());
				if(num == 1) {//상품 입력
					input();
				}else if(num == 2) {//상품 목록 보기
					output();
				}else if(num == 3) {//종료
					System.out.println("프로그램 종료");
					break;
				}else {
					System.out.println("잘못 입력했습니다.");
				}
			}catch(NumberFormatException e) {
				System.out.println("숫자만 허용!!");
			}
		}
	}
	
	//상품 정보 입력(메서드)
	public void input() throws IOException{
		Product p = new Product();
		System.out.print("상품명: ");
		//기본 생성자로 Product 객체를 생성했기 때문에 set 메서드로 입력 받음
		p.setName(br.readLine());
		System.out.print("상품번호: ");
		p.setNum(br.readLine());
		System.out.print("가격: ");
		p.setPrice(Integer.parseInt(br.readLine()));
		System.out.print("제조사: ");
		p.setMaker(br.readLine());
		System.out.print("재고 수량: ");
		p.setStock(Integer.parseInt(br.readLine()));
		
		//Product를 ArrayList에 저장
		//이 안에 while이 있어서 계속 객체 생성하며 입력, 저장할 수 있음.
		list.add(p);
		//아래와 같이 ArrayList에 Product 객체 하나가 추가될 때마다
		//안내 문구를 추가할 수도 있음.
		System.out.println("상품 정보 1건이 추가되었습니다.");
	}
	
	//상품 정보 출력(메서드)
	public void output() {
		System.out.println("상품 리스트: 총 상품수(" + list.size() + "}");
		System.out.println("상품명\t상품번호\t가격\t제조사\t재고 수량");
		System.out.println("==============================");
		//확장 for문
		for(Product pt: list) {
			System.out.printf("%s\t", pt.getName());
			System.out.printf("%s\t", pt.getNum());
			System.out.printf("%,d원\t", pt.getPrice());
			System.out.printf("%s\t", pt.getMaker());
			System.out.printf("%d개\n", pt.getStock());
		}
		System.out.println("==============================");
	}
	
	//메인에서는 생성자만 호출, 코드는 다 생성자 안으로
	public static void main(String[] args) {
		new ProductMain();//생성자 호출
	}
}
