package kr.s05.operation;

public class WhileMain03 {
	public static void main(String[] args) {
		java.util.Scanner input = new java.util.Scanner(System.in);
		
		System.out.print("단 입력 : ");
		int dan = input.nextInt();
		
		System.out.println(dan + "단");
		System.out.println("===============");
		
		int i=1;//초기값
		while(i <=9) {//i: 곱해지는 수 1~9
			System.out.println(dan + "*" + i + "=" + dan*i);
			//위와 같이 한 단에 대해 1 곱하고 나면 2 곱하고 3 곱하고 ~ 9까지
			i++;//증감식
		}
		//while 반복문을 빠져 나오면 아래와 같이 출력되도록 내가 정함^^!
		System.out.println("구구단 외우기 끝");
		
		input.close();
	}
}
