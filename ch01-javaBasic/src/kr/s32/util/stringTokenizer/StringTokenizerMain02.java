package kr.s32.util.stringTokenizer;

import java.util.StringTokenizer;

public class StringTokenizerMain02 {
	public static void main(String[] args) {
		String source = "2023-09-13 14:25:20";//구분자 3개
		//StringTokenizer는 복수의 구분자 사용 가능
                                                //대상 문자열,  구분자
		StringTokenizer st = new StringTokenizer(source, "-  :");
		while(st.hasMoreElements()) {
			System.out.println(st.nextToken());
		}
	}
}
