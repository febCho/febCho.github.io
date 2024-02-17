package kr.s05.operation;

public class ContinueMain {
	public static void main(String[] args) {
		for(int i=0;i<=10;i++) {
			//특정 조건일 때 수행문의 실행을 멈추고 다음 반복 회ㅏ로 건너뜀
			if(i%3==0) {//3의 배수
				continue;
			}
			System.out.println(i);//0~10출력
		}
	}
}
