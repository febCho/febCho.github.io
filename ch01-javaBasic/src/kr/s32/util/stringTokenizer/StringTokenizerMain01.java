package kr.s32.util.stringTokenizer;

import java.util.StringTokenizer;

public class StringTokenizerMain01 {
	public static void main(String[] args) {
		String source = "100,200,300";
	                                           //대상문자열, 구분자	
		StringTokenizer st = new StringTokenizer(source, ",");
		while(st.hasMoreElements()) {//구분자로 잘라낸 문자열이 존재하면 true
			                        //존재하지 않는다면 false
			System.out.println(st.nextToken());//구분자를 기준으로 잘려진 문자열 반환
		}
	}
}
