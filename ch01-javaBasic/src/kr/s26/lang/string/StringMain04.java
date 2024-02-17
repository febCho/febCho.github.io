package kr.s26.lang.string;

import java.util.Scanner;

public class StringMain04 {
	public static void main(String[] args) {
		/*
		 * [실습]
		 * 입력받은 문자열을 한 문자씩 읽어서 역순으로 표시하시오.
		 * 
		 * [입력 예시]
		 * 문자열: hello
		 * 
		 * [출력 예시]
		 * olleh
		 */
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("문자열: ");
		String st = input.nextLine();
		
		for(int i=st.length()-1;i>=0;i--) {
			System.out.print(st.charAt(i));
		}
		//for(int i=0;i<n.length();i++){
		//우리가 입력한 순서대로 출력
		//System.out.print(ch.charAt(i));}
		
		input.close();
	}
}
