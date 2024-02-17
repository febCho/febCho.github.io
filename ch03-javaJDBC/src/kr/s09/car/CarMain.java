package kr.s09.car;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class CarMain {
	private BufferedReader br;
	private CarDAO dao;
	
	public CarMain() {
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			dao = new CarDAO();
			//메뉴 호출
			callMenu();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(br!=null)try {br.close();}catch(IOException e) {}
		}
	}
	
	//메뉴
	public void callMenu() throws IOException{
		while(true) {
			System.out.print("1. 자동차 정보 등록, 2. 목록 보기, "
					+ "3. 자동차 상세 정보 조회, 4. 정보 수정, 5. 정보 삭제, 6. 종료>");
			try {
				int no = Integer.parseInt(br.readLine());
				if(no == 1) {//자동차 정보 등록
					System.out.print("이름:");
					String name = br.readLine();
					System.out.print("차량 번호:");
					String cnumber = br.readLine();
					System.out.print("색상:");
					String color = br.readLine();
					System.out.print("제조사:");
					String maker = br.readLine();
					System.out.print("가격:");
					Integer price = Integer.parseInt(br.readLine());
					
					dao.insertCar(name, cnumber, color, maker, price);
					
				}else if(no == 2) {//목록 보기
					dao.selectcar();
					
				}else if(no == 3) {//자동차 상세 정보 조회
					//목록 보기
					dao.selectcar();
					
					System.out.print("조회할 차량 관리 번호:");
					int num = Integer.parseInt(br.readLine());
					System.out.println("==============================");
					//조회하기
					dao.selectDetailCar(num);
					System.out.println("==============================");
					
				}else if(no == 4) {//정보 수정
					//목록 보기
					dao.selectcar();
					
					System.out.print("수정할 차량 관리 번호 입력:");
					int num = Integer.parseInt(br.readLine());
					//상세 정보 보기
					dao.selectDetailCar(num);
					System.out.println("========================");
					
					System.out.print("이름:");
					String name = br.readLine();
					System.out.print("차량 번호:");
					String cnumber = br.readLine();
					System.out.print("색상:");
					String color = br.readLine();
					System.out.print("제조사:");
					String maker = br.readLine();
					System.out.print("가격:");
					int price = Integer.parseInt(br.readLine());
					
					//수정하기
					dao.updateCar(num, name, cnumber, color, maker, price);
					
				}else if(no == 5) {//정보 삭제
					//목록 보기
					dao.selectcar();
					
					System.out.print("삭제할 차량 관리 번호 입력:");
					int num = Integer.parseInt(br.readLine());
					//삭제하기
					dao.deleteCar(num);
					
				}else if(no == 6) {//종료
					System.out.println("[프로그램을 종료합니다.]");
					break;
				}else {
					System.out.println("[잘못 입력하였습니다.]");
				}
			}catch(NumberFormatException e) {
				System.out.println("[숫자만 입력 가능합니다.]");
			}
		}
	}
	public static void main(String[] args) {
		new CarMain();
	}
}
