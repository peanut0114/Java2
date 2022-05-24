package com.yedam.example;
/*
 * 학생이 대중교통을 타는 상황
 * 객체 : 학생, 대중교통, 버스(식별정보, 요금, 모인 돈)
 */
public class Bus {
	//객체
	private String busNo;
	private int pay;
	private int money;
	private int passengerCount;
	
	//생성자
	//!!클래스와 이름이 똑같아야함!!
	public Bus(String busNum, int pay) {
		this.busNo = busNum;
		this.pay = pay;
	}
	
	//메소드
	public int getPay() {
		return pay;
	}
	
	public void take(int money) {
		this.money += money;
		passengerCount++;
	}
	
	public void showInfo() {
		System.out.printf("%s 버스의 승객은 %d명이고, 수입은 %d원입니다.\n",busNo,passengerCount,money);
	}
	

}
