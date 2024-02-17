package kr.s10.object.method;

public class MethodMain03 {
	/*
	 * [실습]
	 * 배열의 요소수를 입력 받아서 배열 x 생성
	 * 입력 받은 정수를 배열 x에 저장하고 배열 x가 가진 모든 요소의
	 * 합을 구하는 sumof(int[] a) 메서드를 정의하시오.
	 * 
	 * [입력 예시]
	 * 요소 수: 3
	 * x[0]: 10
	 * x[1]: 20
	 * x[2]: 30
	 * 
	 * [출력 예시]
	 * 모든 요소의 합은 60입니다.
	 */
	
	public int sumof(int[] a) {
		int sum = 0;
		for(int i=0;i<a.length;i++) {
			sum += a[i];
		}
		return sum;//루프를 돌며 sum에 배열 값을 누적한 뒤 끝나면 반환
	}
	public static void main(String[] args) {
		java.util.Scanner input = new java.util.Scanner(System.in);
		
		System.out.print("요소 수: ");
		int num = input.nextInt();
		
		int[] x = new int[num];//num개의 요소를 가진 배열
		
		for(int i=0;i<num;i++) {
			System.out.print("x[" + i + "]: ");
			x[i] = input.nextInt();
		}
		MethodMain03 method = new MethodMain03();
		int result = method.sumof(x);//메서드에 우리가 만든 배열 넘기기
		System.out.println("모든 요소의 합은 " + result + "입니다.");
		
		input.close();
	}
}
