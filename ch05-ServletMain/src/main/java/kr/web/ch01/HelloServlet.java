package kr.web.ch01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//주소 지정
@WebServlet("/helloServlet")
public class HelloServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,
			          HttpServletResponse response)
	                  throws ServletException, IOException{
		
		//문서 타입 및 캐릭터셋 지정
		response.setContentType("text/html;charset=utf-8");
		
		//HTML 출력을 위한 출력 스트림 생성
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>Hello Servlet</title></head>");
		out.println("<body>");
		out.println("처음 작성하는 Servlet입니다.");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
	
}
