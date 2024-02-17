package kr.web.ch01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/numSearch")
public class NumServlet extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest request,
			          HttpServletResponse response)
	                  throws ServletException, IOException{
		/*
		 * [실습]
		 * 전송된 데이터가 짝수 or 홀수 판별
		 * [출력 예시]
		 * 짝수입니다. or 홀수입니다.
		 */
		
		int num = Integer.parseInt(request.getParameter("num"));
		
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>짝수/홀수 구하기</title></head>");
		out.println("<body>");
		
		if(num%2 == 1) {
			out.println("홀수입니다.");
		}else {
			out.println("짝수입니다.");
		}
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}
