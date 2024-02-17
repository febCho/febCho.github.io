package kr.s05.operation;

public class IfMain02 {
	public static void main(String[] args) {
		System.out.println("===단일if문===");
		
		java.util.Scanner input = new java.util.Scanner(System.in);
		
		System.out.print("정수 하나 입력 : ");
		int a = input.nextInt();
		
		if(a < 0)
			a = -a;
		
		System.out.println("절대값은 " + a + "이다");
		
		input.close();
	}
}
