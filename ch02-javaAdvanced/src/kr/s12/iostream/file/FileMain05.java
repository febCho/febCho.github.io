package kr.s12.iostream.file;

import java.io.File;

public class FileMain05 {
	public static void main(String[] args) {
		//생성할 디렉토리 지정
		//String path = "C:\\javaSample\\"; - 뒤에 있는 \\ 생략 가능
		
		//File.separator: OS가 기본적으로 사용하는 디렉토리 구분자를 읽어옴
		String path = "C:" + File.separator + "javaSample";
		
		System.out.println("===디렉토리 생성===");
		File f1 = new File(path);
		
		//디렉토리를 생성할 수 있으면 생성후 true 반환
		//생성할 수 없으면 false 반환
		System.out.println(f1.mkdir());
	}
}
