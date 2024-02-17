package kr.s02.collections.list3;

public class Member {
	/*
	 * [실습]
	 * 1. 멤버 변수 : 이름(name), 나이(age), 직업(job), 주소(address), 전화번호(phone)
	 * 2. 생성자: 인자가 없는 생성자, 인자가 있는 생성자 정의
	 * 3. set/get 메서드 생성
	 */
	
	private String name;
	private int age;
	private String job;
	private String address;
	private String phone;
	
	public Member() {}

	public Member(String name, int age, String job, String address, String phone) {
		super();
		this.name = name;
		this.age = age;
		this.job = job;
		this.address = address;
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	};
}
