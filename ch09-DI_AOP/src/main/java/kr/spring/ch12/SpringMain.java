package kr.spring.ch12;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {
	public static void main(String[] args) {
		//applicationContext2.xml 설정 파일을 읽어들여 스프링 컨테이너 생성
		AbstractApplicationContext context = 
		new ClassPathXmlApplicationContext("applicationContext2.xml");
		
		//Set 타입 프로퍼티 설정
		VideoClient video = (VideoClient)context.getBean("videoClient");
		System.out.println(video);
		
		context.close();
	}
}
