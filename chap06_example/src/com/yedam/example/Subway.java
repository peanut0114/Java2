package com.yedam.example;
/*
 * 학생이 대중교통을 타는 상황
 * 객체 : 학생, 대중교통(식별정보, 비용, 모인 돈)
 */
public class Subway {

	//필드
	private String lineNumber;
	private int pay;			//비용
	private int money;
	private int passengerCount;	//승객이 몇명이나 탔는지
	
	//생성자
	public Subway(String lineNumber, int pay) {
		this.lineNumber=lineNumber;
		this.pay = pay;
	}
	
	//메서드
	public int getPay() {
		return pay;
	}
	
	public void take(int money) {
		this.money += money;
		this.passengerCount++;
	}
	
	public void showInfo() {
		System.out.printf("%s의 승객은 %d명이고, 수입은 %d원입니다.\n",lineNumber,passengerCount,money);
		
	}
}
