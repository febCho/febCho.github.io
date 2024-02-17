package kr.spring.ch03;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {
	public static void main(String[] args) {
		/*
		 * applicationContext.xml 설정파일을 읽어들여 스프링 컨테이너를 생성
		 */
		AbstractApplicationContext context = 
		new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//객체를 컨테이너로부터 읽어들임
		OperatorBean bean = (OperatorBean)context.getBean("operatorBean");
		int result = bean.add(10, 20);
		System.out.println("result : " + result);
		
		//애플리케이션 종료 시 컨테이너에 존재하는 모든 빈(객체)를 종료
		context.close();
	}
}
