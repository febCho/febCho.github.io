package kr.web.ch03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/lifeCycle")
public class LifeCycle extends HttpServlet{
	int initCnt = 0;
	int serviceCnt = 0;
	int destroyCnt = 0;
	
	@Override
	public void init() throws ServletException{
		System.out.println("init 메서드는 첫 요청만 호출됨 : " + (++initCnt));
	}
	
	@Override
	public void service(HttpServletRequest request,
            			HttpServletResponse response)
                    throws ServletException, IOException{
		System.out.println("service 메서드가 요청될 때마다 호출됨 : " + (++serviceCnt));
		
		//문서 타입 및 캐릭터셋 지정
		response.setContentType("text/html;charset=utf-8");
		//HTML 출력을 위한 출력 스트림 생성
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>Servlet LifeCycle</title></head>");
		out.println("<body>");
		out.println("서블릿 init()의 호출 횟수 : " + initCnt + "<br>");
		out.println("서블릿 service()의 호출 횟수 : " + serviceCnt);
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
	       
	@Override
	public void destroy() {
		System.out.println("destroy 메서드는 본 Servlet이 더 이상 사용되지 않을 때만 호출됨 : "
				+ (++destroyCnt));
	}
}
