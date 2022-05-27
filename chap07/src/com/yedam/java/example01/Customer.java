package com.yedam.java.example01;

public class Customer {
	//필드
	int customerId;	//고객 아이디
	String customerName;	//고객이름
	String customerGrade;	//고객 등급
	int bonusPoint;	//보너스 포인트
	double bonusRatio;	//보너스 포인트 적립율
	
	
	//생성자
	public Customer() {
		this.customerGrade = "SILVER";
		this.bonusRatio = 0.01;
	}
	
	public Customer(int customerId, String customerName) {	//새 고객정보
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerGrade = "SILVER";
		this.bonusRatio = 0.01;
	}
	
	//메소드
	public int calPrice(int price) {	//가격만큼 적립금 추가
		this.bonusPoint += price* this.bonusRatio;	
		return price;
	}
	
	public String showInfo() {
		return customerName+"님의 등급은"+customerGrade+"이며,보너스 포인트는"+bonusPoint+"입니다.";
	}
	
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public String getCustomerName(){
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerGrade(){
		return customerGrade;
	}
	public void setCustomerGrade(String customerGrade) {
		this.customerGrade = customerGrade;
	}
	public int getBonusPoint() {
		return bonusPoint;
	}
	public void setBonusPoint(int bonusPoint) {
		this.bonusPoint = bonusPoint;
	}
	public double getBonusRatio() {
		return bonusRatio;
	}
	public void setBonusRatio(double bonusRatio) {
		this.bonusRatio = bonusRatio;
	}

}
