package kr.web.ch02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet{
	@Override
	public void doPost(HttpServletRequest request,
			           HttpServletResponse response)
	                   throws ServletException, IOException{
		//전송된 데이터 인코딩 처리
		request.setCharacterEncoding("utf-8");
		//전송된 데이터 반환
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String job = request.getParameter("job");
		String[] phones = request.getParameterValues("phone");
		
		//문서 타입 및 캐릭터셋 지정
		response.setContentType("text/html;charset=utf-8");
		
		//HTML 출력을 위한 출력 스트림 생성
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>회원가입</title></head>");
		out.println("<body>");
		out.println("회원님 가입을 축하합니다.<br> 회원정보<br>");
		out.println("이름 : " + name + "<br>");
		out.println("나이 : " + age + "살<br>");
		out.println("직업 : " + job + "<br>");
		
		out.println("전화번호 : ");
		/*
		 * 전화번호를 입력하지 않았을 경우 빈 문자열 형태로 전송되기 때문에
		 * 빈 문자열 체크
		 */
		if(!phones[0].equals("") && !phones[1].equals("") && !phones[2].equals("")) {
			for(int i=0;i<phones.length;i++) {
				out.print(phones[i]);
				if(i<phones.length-1) out.println("-");//마지막 인덱스를 호출하고 나면
				                                       //-를 출력하지 않음
			}
		}else {
			out.println("잘못 명시");
		}
		
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}
