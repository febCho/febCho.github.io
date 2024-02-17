package kr.s11.enumtest;

enum Item2{
	ADD(5), DEL(11), SEARCH(2), CANCEL(22);
	
	//위에서 지정한 상수 값들을 저장하기 위한 공간
	//(final이 아니어도 상관 없음)
	private final int var;
	
	//생성자
	Item2(int var){//var에 소괄호 안 정수들이 저장됨
		this.var = var;
	}
	
	public int getVar() {
		return var;
	}
}
public class EnumMain05 {
	public static void main(String[] args) {
		System.out.println(Item2.ADD);
		System.out.println(Item2.DEL);
		System.out.println(Item2.SEARCH);
		System.out.println(Item2.CANCEL);
		System.out.println("====================");
		System.out.println(Item2.ADD.getVar());
		System.out.println(Item2.DEL.getVar());
		System.out.println(Item2.SEARCH.getVar());
		System.out.println(Item2.CANCEL.getVar());
		System.out.println("====================");
		
		//확장 for문을 활용한 출력
		             //Item2[]인 것, 굳이 배열명을 안 써준 것뿐임
		for(Item2 n : Item2.values()) {
			System.out.println(n + " : " + n.getVar());
		}
		
	}
}
