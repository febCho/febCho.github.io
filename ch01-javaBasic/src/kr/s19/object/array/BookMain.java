package kr.s19.object.array;

public class BookMain {
	public static void main(String[] args) {
		Book[] bookArray = new Book[3];
		int total = 0;
		
		//Book 객체를 3개 생성해서 배열에 저장
		//CarMain과 달리, 기본 생성자가 아니라 인자가 있는 생성자라 명시하기 용이
		bookArray[0] = new Book("IT", "Java", 50000, 0.05);
		bookArray[1] = new Book("IT", "Oracle", 40000, 0.03);
		bookArray[2] = new Book("미술", "반 고흐", 60000, 0.06);
		
		//반복문을 이용해 객체의 멤버 변수 값 출력
		for(int i=0;i<bookArray.length;i++) {
			System.out.printf("%s\t", bookArray[i].getCategory());
			System.out.printf("%s\t", bookArray[i].getName());
			System.out.printf("%,d원\t", bookArray[i].getPrice());
			System.out.printf("%.2f%%%n", bookArray[i].getDiscount());
			//합계
			total += bookArray[i].getPrice();
		}
		System.out.printf("책 가격의 합: %,d원%n", total);
		
		//확장 for문을 이용한 출력
		int total2 = 0;
		
		for(Book book : bookArray) {
			System.out.printf("%s\t", book.getCategory());
			System.out.printf("%s\t", book.getName());
			System.out.printf("%,d원\t", book.getPrice());
			System.out.printf("%.2f%%%n", book.getDiscount());
			//합계
			total2 += book.getPrice();
		}
		System.out.printf("책 가격의 합: %,d원%n", total2);
	}
}
