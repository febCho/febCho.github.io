package kr.s03.cast;

public class CastMain01 {
	public static void main(String[] args) {
		System.out.println("===묵시적 형변환(자동 형변환)===");
		//더 큰 자료형으로 승격이 일어나는 형태, 정보의 손실이 전혀 없으며
		//자동적으로 발생
		
		byte b1 = 127;
		byte b2 = 127;
		//byte result = b1+b2;
		int result = b1+b2;//32bit 미만의 자료형 즉,
		                  //byte형 데이터들을 연산하면 32bit로 승격
		System.out.println("result = " + result);
		
		short s1 = 32767;
		short s2 = 32767;
		//short result = s1 + s2;
		int result2 = s1 + s2;//32bit 미만의 자료형 즉,
		                      //short형 데이터들을 연산하면 32bit로 승격
		System.out.println("result2 = " + result2);
		
		int in2 = 1234;
		long lg2 = 2345L;
			         //in2: int -> long 자동 형변환
		long result3 = in2 + lg2;
		System.out.println("result3 = " + result3);
		
		int in3 = 25;
		double db = 10.5;
			           //in3: int => double 자동 형변환
		double result4 = in3 + db;//25.0 + 10.5
		System.out.println("result4 = " + result4);
}
}