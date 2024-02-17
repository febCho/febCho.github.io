package kr.s04.operator;

public class OperatorMain08 {
	public static void main(String[] args) {
		//증감연산자, 비교연산자, 논리연산자
		int a, b;
		a = b = 10;
		
		boolean c = a++ >= ++b && ++a > b++;
		           //10    11
		           // false(이므로)  미실행
		System.out.println(a + "," + b);//후조건 미실행으로 a = 11
		                                //b = 11
		System.out.println("c : " + c);//false
		System.out.println("=============");
		
		int d,e;
		d = e = 10;
		
		boolean f = ++d > e++ || d++ >= ++e;
		           //11   10
		           // true(이므로)    미실행
		System.out.println(d + "," + e);//11, 11
		System.out.println("f : " + f);//true
		
		
		int g,h;
		g = h = 10;
		
		boolean i = ++g < h++ || g++ >= ++h;
		           //11   10     11    12
		           //  false       false
		System.out.println(g + "," + h);//12, 12
		System.out.println("i = " + i);//false
	}
}
