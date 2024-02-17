package kr.s12.iostream.file;

import java.io.File;

public class FileMain04 {
	public static void main(String[] args) {
		//파일 삭제
		
		//상대경로 지정
		String path = "example.txt";
				
		File f1 = new File(path);
				
		System.out.println("===파일 삭제===");
		//delete() : 삭제할 수 있으면 삭제하고 true 반환,
		//           삭제가 불가능하면 false 반환
		if(f1.delete()) {//파일 삭제가 됐따면
			System.out.println(f1.getName() + " 파일 삭제");
		}else {//삭제하지 못했다면
			System.out.println("파일을 삭제하지 못하였습니다.");
		}
	}
}
