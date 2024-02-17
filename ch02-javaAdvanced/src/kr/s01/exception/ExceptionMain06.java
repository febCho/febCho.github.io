package kr.s01.exception;

public class ExceptionMain06 {
	
	public void methodA(String[] n) throws Exception{
		if(n.length>0) {
			for(String s : n) {
				System.out.println(s);
			}
		}else {//아무것도 입력하지 않은 경우(길이 0)
			//인위적으로 예외 발생
			//인위적으로 예외를 발생시킬 때는 try~catch로 감싸거나
			//메서드에서 사용할 경우 throws 예약어를 사용해야
			//오류가 발생하지 않음.
			throw new Exception("배열에 요소가 없습니다.");
			//위 코드에 throw가 없다면 그냥 예외 객체가 만들어진 거고
			//throw를 통해 예외 객체를 만든 걸 try~catch로 던져야만 함.
		}
	}
	
	public static void main(String[] args) {
		ExceptionMain06 ex = new ExceptionMain06();
		//ex.methodA(args);
		//try~catch를 명시하지 않으면 컴파일 에러 발생
		//throws는 예외 처리가 아니라 예외를 임시 보관할 뿐이니까
		
		try {
			ex.methodA(args);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			//new Exception(~~~~) > 이 생성자를 통해 만들어진 문구는
			//getMessage를 통해 뽑아낼 수 있음.
		}
	}
}
