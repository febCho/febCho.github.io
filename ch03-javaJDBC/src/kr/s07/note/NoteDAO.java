package kr.s07.note;

/*
 * DAO : Data Access Object
 *       데이터베이스의 데이터를 전문적으로 호출하고 제어하는 객체
 */

public class NoteDAO {
	//글 쓰기
	public void insertInfo(String name, String passwd,
			               String subject, String content,
			               String email) {
		//데이터 베이스 연동
		System.out.println("[글 쓰기를 완료했습니다.]");
	}
	
	//목록 보기
	public void selectInfo() {
		//데이터 베이스 연동
		System.out.println("[작성한 글 목록을 표시합니다.]");
	}
	
	//상세 글 보기
	public void selectDetailInfo(int num) {//pk 넘겨주기
		//데이터 베이스 연동
		System.out.println("[한 건의 상세 글 정보를 출력합니다.]");
	}
	
	//글 수정
	public void updateInfo(int num, String name, String passwd,
			               String subject, String content, String email) {
		//데이터 베이스 연동
		System.out.println("[한 건의 글 정보를 수정했습니다.]");
	}
	
	//글 삭제
	public void deleteInfo(int num) {
		//데이터 베이스 연동
		System.out.println("[한 건의 글 정보를 삭제했습니다.]");
	}
}
