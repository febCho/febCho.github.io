package kr.s19.network;

import java.net.MalformedURLException;
import java.net.URL;

public class URLMain01 {
	public static void main(String[] args) {
		try {
			URL url = new URL("http://java.sun.com/index.jsp?name=kim#content");
			
			System.out.println("프로토콜: " + url.getProtocol());
			System.out.println("호스트: " + url.getHost());
			System.out.println("포트: " + url.getPort());
			System.out.println("기본 포트: " + url.getDefaultPort());
			System.out.println("패스: " + url.getPath());
			System.out.println("쿼리: " + url.getQuery());
			System.out.println("ref: " + url.getRef());
			
		}catch(MalformedURLException e) {
			e.printStackTrace();
		}
	}
}
