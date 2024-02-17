package kr.s12.iostream.file;

import java.io.File;

public class FileMain01 {
	public static void main(String[] args) {
		String path = "C:\\"; //'\'는 폴더 구분자이며, 특수문자
		
		File f = new File(path);
		
		//파일에 접근하기 위해서도 먼저 디렉토리를 거쳐야 하기 때문
		//exists(): 디렉토리 또는 파일이 존재하느냐
		//isDirectory(): 디렉토리여야만 안에 하위 디렉토리나 파일이 존재하기 때문에
		if(!f.exists() || !f.isDirectory()) {
			System.out.println("유효하지 않은 디렉토리입니다.");
			System.exit(0);//프로그램 종료
		}
		
		//지정한 경로의 하위 경로와 파일 정보를 File 배열로 반환
		File[] files = f.listFiles();
		for(int i=0;i<files.length;i++) {
			File f2 = files[i];
			if(f2.isDirectory()) {
				//디렉토리는 용량이 없기 때문에 아래와 같이 이름만 명시
				System.out.println("[" + f2.getName() + "]");
			}else {//파일은 용량을 가지므로
				System.out.print(f2.getName());
				                         //File 객체에선 파일의 용량
				System.out.printf("(%,dbytes)%n", f2.length());
			}
		}
	}

}
