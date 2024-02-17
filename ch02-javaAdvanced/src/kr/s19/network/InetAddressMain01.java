package kr.s19.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressMain01 {
	public static void main(String[] args) {
		BufferedReader br = null;
		InetAddress iaddr = null;
		String url = null;
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.print("도메인명 입력: ");
			url = br.readLine();
			
			//InetAddress 객체 안에 Host 정보 등을 가져오는 메서드가 존재
			
			iaddr = InetAddress.getByName(url);
			System.out.println("호스트 이름: " + iaddr.getHostName());
			System.out.println("호스트 IP주소: " + iaddr.getHostAddress());
			
			System.out.println("=====================");
			
			//로컬 호스트 IP주소 구하기
			iaddr = InetAddress.getLocalHost();
			System.out.println("로컬 호스트 이름: " + iaddr.getHostName());
			System.out.println("로컬 호스트 IP주소: " + iaddr.getHostAddress());
			
		}catch(UnknownHostException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			if(br!=null)try {br.close();}catch(IOException e) {}
		}
	}
}
