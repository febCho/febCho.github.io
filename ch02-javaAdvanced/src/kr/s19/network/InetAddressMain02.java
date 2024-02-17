package kr.s19.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressMain02 {
	public static void main(String[] args) {
		BufferedReader br = null;
		InetAddress[] addresses;
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.print("도메인명 입력> ");
			String url = br.readLine();
			
			//getByName은 하나의 이름만 반환하기 때문에 getAllByName 사용
			//해당 도메인과 매핑되어 있는 모든 주소를 IndetAddress 배열 형태로 반환
			addresses = InetAddress.getAllByName(url);
			for(int i=0;i<addresses.length;i++) {
				                             //배열 안에 있는 객체에 접근해 호출
				System.out.println("호스트 이름 : " + addresses[i].getHostName()
						      + ", IP주소 : " + addresses[i].getHostAddress());
			}
			
		}catch(UnknownHostException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			if(br!=null)try {br.close();}catch(IOException e) {}
		}
	}
}
