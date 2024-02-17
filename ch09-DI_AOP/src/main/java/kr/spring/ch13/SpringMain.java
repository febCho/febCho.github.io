package kr.spring.ch13;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {
	public static void main(String[] args) {
		//applicationContext2.xml 설정 파일을 읽어들여 스프링 컨테이너 생성
		AbstractApplicationContext context = 
		new ClassPathXmlApplicationContext("applicationContext2.xml");
		
		//Properties 타입 프로퍼티 설정
		BookClient book = (BookClient)context.getBean("bookClient");
		System.out.println(book);
		
		context.close();
	}
}
