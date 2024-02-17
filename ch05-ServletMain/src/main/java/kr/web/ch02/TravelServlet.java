package kr.web.ch02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/travel")
public class TravelServlet extends HttpServlet{
	@Override
	public void doPost(HttpServletRequest request,
			           HttpServletResponse response)
	                   throws ServletException, IOException{
		/*
		 * [실습]
		 * name, city 전송된 데이터를 받아서 출력하기
		 * [출력 예시]
		 * 이름 : 홍길동
		 * 여행지 : 서울, 파리
		 */
		//전송된 데이터 인코딩 처리
		request.setCharacterEncoding("utf-8");
		//문서 타입 및 캐릭터셋 지정
		response.setContentType("text/html;charset=utf-8");
		
		//HTML 출력을 위한 출력 스트림 생성
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>여행지를 선택하세요(2개 이상 선택)</title></head>");
		out.println("<body>");
		
		String name = request.getParameter("name");
		out.println("이름 : " + name + "<br>");
		
		String[] cities = request.getParameterValues("city");
		
		if(cities != null) {
			out.println("여행지 : ");
			for(int i=0;i<cities.length;i++) {
				out.print(cities[i]);
				if(i<cities.length-1) out.println(",");
			}
		}else {
			out.println("여행지를 선택하지 않음");
		}
		
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}
