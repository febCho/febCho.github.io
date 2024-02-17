package kr.s01.basic;

public class DriverMain {
	public static void main(String[] args) {
		try {
			//별도의 생성자 없이 해당 경로에 찾고자 하는 클래스가 있는지 확인해 메모리에 올려줌
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("오라클 드라이버가 정상적으로 로드되었습니다.");
		}catch(ClassNotFoundException e) {//찾고자 하는 게 없다면
			e.printStackTrace();
		}
	}
}
