package kr.web.ch01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/myInfo")
public class MyInfoServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,
			          HttpServletResponse response)
	                  throws ServletException, IOException{
		/*
		 * [실습] 개인 정보 출력하기
		 * (데이터를 저장할 변수 지정, name, age, job, address)
		 * 이름 : 홍길동
		 * 나이 : 20살
		 * 직업 : 학생
		 * 주소 : 서울시
		 */
		
		String name = "마리오";
		int age = 25;
		String job = "배관공";
		String address = "브루클린";
		
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>[실습] 개인 정보 출력하기</title></head>");
		out.println("<body>");
		out.println("이름 : " + name + "<br>");
		out.println("나이 : " + age + "살<br>");
		out.println("직업 : " + job + "<br>");
		out.println("주소 : " + address);
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

}
