package kr.spring.ch05;

public class MemberService {
	private MemberDAO memberDAO;
	
	//생성자
	public MemberService(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	
	public void send() {
		System.out.println("MemberService의 send() 메서드 실행");
		
		memberDAO.register();
	}
}
