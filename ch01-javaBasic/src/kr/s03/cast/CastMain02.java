package kr.s03.cast;

public class CastMain02 {
	public static void main(String[] args) {
		System.out.println("===명시적 형변환(강제 형변환)===");
		//더 작은 자료형으로 강등이 일어나는 형태, 정보의 손실이 발생할 수 있음.
		byte b1 = 127;
		byte b2 = 127;
		//int result = b1 + b2; 원래는 이렇게 하겠지만
		byte result = (byte)(b1+b2);//자동적으로 int로 형변환된 것을
		//byte로 강제 형변환, 이때 (byte)를 캐스트 연산자라고 함.
		//(b1+b2)처럼 소괄호를 해주지 않으면 b1만 형변환 함.
		System.out.println("result = " + result);
		
		short s1 = 32767;
		short s2 = 32767;
		//int result2 = s1 + s2; 원래는 이렇게 하겠지만
		short result2 = (short)(s1 + s2);//자동적으로 int로 형변환된 것을
		//short로 강제 형변환
		System.out.println("result2 = " + result2);
		
		int in1 = 100;
		long lg1 = 200L;
		                   //lg1 : long -> int 강제 형변환
		int result3 = in1 + (int)lg1;
		System.out.println("result3 = " + result3);
		//int가 long보다 작지만, 300을 충분히 담을 수 있기 때문에 왜곡 x
		
		int in2 = 26;
		float ft = 10.3f;
		
		int result4 = in2 + (int)ft;
		System.out.println("result4 = " + result4);
		//int는 정수만 담을 수 있으므로 0.3이 절삭되어 정보 왜곡 o
	}
}
