package kr.s18.iostream.serial;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.io.IOException;

public class CustomerMain02 {
	public static void main(String[] args) {
		System.out.println("===객체 역직렬화===");
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			//파일을 읽어옴
			fis = new FileInputStream("object.ser");
			ois = new ObjectInputStream(fis);
			
			//역직렬화 수행
			//readObject(Object 타입으로 반환) 때문에 Customer로 다운캐스팅
			//readObject 메서드 수행 시 ClassNotFoundException 의무 명시
			Customer c = (Customer)ois.readObject();
			System.out.println(c);//toString 재정의 메서드
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			if(ois!=null)try{ois.close();}catch(IOException e) {}
			if(fis!=null)try {fis.close();}catch(IOException e) {}
		}
	}
}
