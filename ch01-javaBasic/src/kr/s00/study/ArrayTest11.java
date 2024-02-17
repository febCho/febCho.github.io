package kr.s00.study;

public class ArrayTest11 {
	public static void main(String[] args) {
		int[][] scoreList = { {76, 92, 49, 78, 83},
				{88, 69},
				{99, 92, 89}
		};
		
		for (int[] array : scoreList) {//scoreList에 딱 들어가서 행에 해당하는 인덱스를 뒤지는 역할
			for (int score : array) {//그렇게 들어간 각 행 내부의 배열에 들어가는 역할
				System.out.print(score + " ");//그래서 최종적으로는 값을 찾아낸 score를 출력
			}
			System.out.println();//줄바꿈
		}
		
	}
}
