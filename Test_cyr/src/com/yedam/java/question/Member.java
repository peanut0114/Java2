package com.yedam.java.question;

public abstract class Member {	//추상클래스 (추상메소드x, 얘만의 인스턴스 생성 불가하게 만듬)
	//필드
	static int GRADE_STANDARD = 1000000;
	int record;
	String grade;
	
	//생성자 하나 (기본생성자 x)
	Member(int record){
		this.record = record;
	}
	
	//메소드
	void showMemberInfo() {
		System.out.printf("현재 실적은 %d이며, 회원등급은 %s입니다.\n",record,grade);
	}
	
	//기준에 따른 멤버쉽 분류
	static Member getMemberShip(int record) {	//정적메소드
		Member member = null;
		if(record >= GRADE_STANDARD) {
			member = new Gold(record);
		} else {
			member = new Silver(record);
		}
		return member;
	} 
}
