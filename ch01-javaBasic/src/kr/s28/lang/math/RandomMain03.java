package kr.s28.lang.math;

import java.util.Arrays;
import java.util.Random;

public class RandomMain03 {
	public static void main(String[] args) {
		/*
		 * [실습]
		 * 로또 프로그램 제작
		 * 길이가 6인 int형 배열 생성하고 1~45 숫자 범위로 난수를 구함.
		 * 중복되지 않는 6개의 숫자를 생성해서 배열에 저장하고 출력하시오.
		 * 난수 생성: Math.random() 또는 Random 클래스의 nextInt() 메서드 사용
		 */
		
		//로또 번호를 저장할 배열 생성
		int[] lotto = new int[6];
		
		Random r1 = new Random();
		for(int i=0;i<lotto.length;i++) {
			lotto[i] = r1.nextInt(45)+1;//0~44 > 1~45
			
			//중복된 숫자가 있는지 검증
			for(int j=0;j<i;j++) {//중복 제거
				if(lotto[i] == lotto[j]) {//여기서 j는 이미 배열에 저장된 로또 번호들
					System.out.println("중복 추출: " + lotto[j]);
					i--; //추출한 수가 같으니까 횟수 한 번 무효
					     //다음 인덱스로 넘어가지 않고 현재 인덱스에 새로 값을 입력하도록 처리
					break;
				}
			}
		}
		//오름차순 정렬
		Arrays.sort(lotto);
		
		//확장 for문을 이용한 출력
		for(int r : lotto) {
			System.out.print(r + "\t");
		}
	}
}
