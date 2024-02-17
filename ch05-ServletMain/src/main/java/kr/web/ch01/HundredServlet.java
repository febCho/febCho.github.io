package kr.web.ch01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hundered")
public class HundredServlet extends HttpServlet {
	public void doGet(HttpServletRequest request,
			          HttpServletResponse response)
	                  throws ServletException, IOException {
		int total = 0;
		for(int i=1;i<=100;i++) {
			total += i;
		}
		
		//문서 타입 및 캐릭터셋 지정
		response.setContentType("text/html;charset=utf-8");
		
		//HTML 출력을 위한 출력 스트림 생성
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>1부터 100까지 더하는 서블릿</title></head>");
		out.println("<body>");
		out.println("1부터 100까지의 합은 " + total);
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}
