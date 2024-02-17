package kr.s06.array;

public class ArrayMain12 {
	public static void main(String[] args) {
		/*
		 * [실습]
		 * 요소의 수를 지정하고 지정된 수로 정수형 배열을 생성해서 해당 배열에
		 * 정수를 저장하시오.
		 * 배열에 저장된 요소를 역순으로 출력하시오.
		 * 
		 * [입력 예시]
		 * 요소수: 3
		 * array[0] : 20
		 * array[1] : 10
		 * array[2] : 5
		 * 
		 * [출력 예시]
		 * 요소를 역순으로 정렬했습니다.
		 * array[0] : 5
		 * array[1] : 10
		 * array[2] : 20
		 */
		
		java.util.Scanner input = new java.util.Scanner(System.in);
		
		System.out.print("요소수: ");
		int num = input.nextInt();
		
		int[] array = new int[num];
		
		for(int i=0;i<array.length;i++) {
			System.out.print("array[" + i + "] : ");
			array[i] = input.nextInt();
		}
		//역순으로 정렬 = 인덱스 대칭인 요소들 바꿔치기
		for(int i=0;i<array.length/2;i++) {
			int t = array[i];//데이터 교체를 위한 임의의 변수 지정
			array[i] = array[array.length-1-i];
			array[array.length-1-i] = t;
			
			/*
			 * 임의의 변수 t에 array[0] 값 넣기
			 * 빈 array[0]에 array[배열 길이 -1-0] 값 넣기
			 *                  (배열 마지막 자릿수)-0
			 * 그 자리에 t에 넣어 두었던 array[0] 값 넣기
			 */
			
		}
		System.out.println("요소를 역순으로 정렬했습니다.");
		//          array 배열 길이가 num이니까
		for(int i=0;i<num;i++) {
			System.out.println("array[" + i + "]: " + array[i]);
		}
		
		input.close();
	}
}
