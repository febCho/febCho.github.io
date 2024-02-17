package kr.spring.ch14;

public class WriteArticleService {
	private WriteArticleDAO writeArticleDAO;

	public void setWriteArticleDAO(WriteArticleDAO writeArticleDAO) {
		this.writeArticleDAO = writeArticleDAO;
	}
	
	public void write() {
		System.out.println("WriteArticleService의 write() 메서드 실행");
		
		writeArticleDAO.insert();
	}
}
