package kr.s06.array;

public class SecondArrayMain03 {
	public static void main(String[] args) {
		
		//다차원 배열을 활용해 인원수를 조절할 수 있고
		//점수 입력도 가능한 성적 프로그램 만들기
		
		java.util.Scanner input = new java.util.Scanner(System.in);
		//과목명(고정) - 문자열 배열
		String[] course = {"국어", "영어", "수학"};
		//인원수(입력)
		System.out.print("인원수: ");
		int num = input.nextInt();
		
		//성적이 저장될 2차원 배열 선언 및 생성
		                  //인원수 = i  과목수 = j
		int[][] score = new int[num][course.length];
		
		//총점       총점이 인원수만큼 만들어질 것
		int[] sum = new int[num];
		
		//평균         평균도 인원수만큼 만들어질 것
		float[] avg = new float[num];
		
		//성적을 입력받고 총점과 평균 구하기
		            //행의 길이 = 인원수 = num
		for(int i=0;i<score.length;i++) {
			       //열의 길이
			for(int j=0;j<score[i].length;j++) {
				//성적 우선 입력 받고 0~100인지 검증
				do {
					System.out.print(course[j] + "=");
					score[i][j] = input.nextInt();
				}while(score[i][j] < 0 || score[i][j] > 100);
				
				//총점 구하기 - 둘 다 배열이니까
				sum[i] += score[i][j];
			}//end of inner for
			
			//평균 구하기 - 둘 다 배열이니까
			avg[i] = sum[i] / (float)score[i].length;//course.length도 가능
			System.out.println();
			
		}//end of outer for
		
		//총점과 평균 출력
		
		for(int i=0;i<num;i++) {
			System.out.println();
			System.out.printf("총점: %d%n", sum[i]);
			System.out.printf("평균: %.2f%n", avg[i]);
		}
		
		input.close();
	}
}
