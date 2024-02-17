package kr.s02.collections.list4;

//사용자 정의 얘외 클래스(성적은 0~100 가능, 나머지는 예외처리)
public class ScoreValueException extends Exception{
	public ScoreValueException(String message) {
		//ScoreValueException 객체가 생성 되면
		//입력 받은 인자인 message를 exception의 생성자로 던져줌.
		super(message);
		
	}

}
