package kr.web.ch02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board")
public class BoardServlet extends HttpServlet{
	@Override
	public void doPost(HttpServletRequest request,
			           HttpServletResponse response)
	                   throws ServletException,IOException{
		/*
		 * [실습]
		 * name, title, content 전송된 데이터를 반환 받아서 출력
		 * [출력 예시]
		 * 이름 : 홍길동
		 * 제목 : 11월의 더위
		 * 내용 : 겨울답지 않은 겨울이네요~~
		 */
		
		//문서 타입 및 캐릭터셋 지정
		response.setContentType("text/html;charset=utf-8");
		//POST 방식으로 데이터가 전송될 때 전송된 데이터 인코딩 처리
		request.setCharacterEncoding("utf-8");
		
		//전송된 데이터 반환
		String name = request.getParameter("name");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		//HTML 출력을 위한 출력 스트림 생성
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>Board</title></head>");
		out.println("<body>");
		out.println("이름 : " + name + "<br>");
		out.println("제목 : " + title + "<br>");
		out.println("내용 : " + content);
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}
