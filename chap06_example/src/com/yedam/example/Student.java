package com.yedam.example;
/*
 * 학생이 대중교통을 타는 상황
 * 객체 : 학생(식별정보,보유 돈), 대중교통
 */
public class Student {

	//필드
	private String name;
	private int money;
	
	//생성자
	//여기서 초기화해주기 때문에 getter,setter 필요X
	public Student(String name, int money) {
		this.name = name;
		this.money = money;
	}
	
	//메서드
	public void take(Subway subway) {
		int pay = subway.getPay();		//내야 할 금액
		this.money -= pay;	//줄어든 돈
		subway.take(pay);	//그만큼 서브웨이가 가져감
	}
	
	public void take(Bus bus) {
		int pay = bus.getPay();
		this.money -= pay;
		bus.take(pay);
	}

	public void showInfo() {
		System.out.printf("%s님의 남은 돈은 %d원입니다.\n",name,money);
	}
}
