package kr.s02.collections.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class ArrayListMain07 {
	public static void main(String[] args) {
		/*
		 * [실습]
		 * 로또 프로그램 제작
		 * 1부터 45까지 중복되지 않는 6개의 숫자를 구해서 ArrayList에 저장하고 출력하시오.
		 * 출력할 때는 오름차순 정렬하여 출력하시오.
		 */
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		Random r1 = new Random();
		while(list.size() < 6) {//인덱스 0부터 출발
			int num = r1.nextInt(45)+1;//num 변수에 난수 1~45 범위로 저장
			
			//중복값 체크
			//배열과 달리, 애초에 변수가 포함되있지 않는다면 if의 수행문인
			//list.add를 통해 list에 저장될 수 없으므로
			//뽑기 횟수를 i--로 리셋해줄 필요가 없음
			if(!list.contains(num)) {//해당 난수를 포함하지 않는다면
				//요소가 중복되지 않았으니 list에 추가
				list.add(num);
			}
		}
		//오름차순 정렬
		Collections.sort(list);
		//확장 for문을 이용한 요소의 출력
		for(Integer no : list) {
			System.out.print(no + "\t");
		}
	}
}
