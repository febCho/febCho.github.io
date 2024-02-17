package kr.spring.ch06;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {
	public static void main(String[] args) {
		/*
		 * applicationContext.xml 설정파일을 읽어들여 스프링 컨테이너를 생성
		 */
		AbstractApplicationContext context = 
		new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//DI 생성자 방식 - 인자를 여러 개 전달
		SystemMonitor monitor = (SystemMonitor)context.getBean("monitor");
		System.out.println(monitor);
		
		context.close();
	}
}
