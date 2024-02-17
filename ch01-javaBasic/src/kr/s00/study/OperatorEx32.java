package kr.s00.study;

public class OperatorEx32 {
	public static void main(String[] args) {
		//조건 연산자를 이용해 변수의 절대값을 구한 후, 부호를 붙여 출력하는 예제
		int x,y,z;
		int absX, absY, absZ;
		char signX, signY, signZ;
		
		x = 10;
		y = -5;
		z = 0;
		
		//x의 값이 음수이면, 양수로 만든다.
		absX = x >= 0 ? x : -x;//x = 10
		absY = y >= 0 ? y : -y;//y = 5
		absZ = z >= 0 ? z : -z;//z = 0
		
		//조건 연산자를 중첩
		signX = x > 0 ? '+' : (x==0 ? ' ' : '-');//signX = '+'
		signY = y > 0 ? '+' : (y==0 ? ' ' : '-');//signY = '+'
		signZ = z > 0 ? '+' : (z==0 ? ' ' : '-');//signZ = ' '
		
		System.out.printf("x=%c%d%n", signX, absX);
		System.out.printf("y=%c%d%n", signY, absY);
		System.out.printf("z=%c%d%n", signZ, absZ);
	}
}
