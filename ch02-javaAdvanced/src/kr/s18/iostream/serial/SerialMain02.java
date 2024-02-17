package kr.s18.iostream.serial;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class SerialMain02 {
	public static void main(String[] args) {
		//역직렬화 하기
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream("userInfo.ser");
			ois = new ObjectInputStream(fis);
					
			//역직렬화 수행: ArrayList는 자료형/캐스팅에도 제네릭 표현을 함께 써준다.
			//Cusoter c = (Customer)ois.readObject();
			ArrayList<UserInfo> list = (ArrayList<UserInfo>)ois.readObject();
			System.out.println(list);//요소의 목록 출력 - toString 재정의 내용 출력
					
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			if(ois!=null)try{ois.close();}catch(IOException e) {}
			if(fis!=null)try {fis.close();}catch(IOException e) {}
		}
	}
}
