package kr.s02.variable;

public class VariableMain01 {
	public static void main(String[] args) {
		//변수(Variable)는 값을 지정할 수 있는 메모리의 공간
		
		//변수 선언
		int num;
		
		//변수의 초기와
		num = 17;
		
		//변수의 값 출력
		System.out.println(num);
		System.out.println("========");
		
		//변수 선언, 초기와
		int number = 20;
		
		//출력
		System.out.println(number);
		
		//데이터 변경
		number = 40;
		//출력
		System.out.println(number);
		System.out.println("=============");
		
		//주의사항
		//동일한 변수명으로 변수를 선언하면 오류 발생
		//int number = 30;
		
		//동일한 자료형을 사용하기 때문에 두 번째 변수명 앞의 자료형은 생략함.
		int a = 10, b = 20;
		int result = a+b;//변수에서 값을 호출해서 연산
		//출력
		System.out.printf("result = %d%n", result);
		
		//주의사항
		System.out.println("결과 : " + a + b);//1020 출력
		System.out.println("결과 : " + (a+b));//30 출력
		
		//변수 선언
		int no;
		
		//변수 선언 후 출력 또는 연산하기 전에 반드시 초기화를 해야 함
		//System.out.println(no);
	}
}
