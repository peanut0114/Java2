package com.yedam.java.example01;

public class Gold extends Customer{

	double saleRatio;
	
	public Gold() {
		this.customerGrade = "GOLD";
		this.bonusRatio = 0.02;
		this.saleRatio = 0.1;
	}
	
	public Gold(int customerId, String customerName) {
		super(customerId, customerName);	
		//이 형태의 변수를 매개로 가지는 부모생성자 불러오는것
		//부모 클래스의 생성자를 불러오는 부분이 필수!
		this.customerGrade = "GOLD";
		this.bonusRatio = 0.02;
		this.saleRatio = 0.1;
	}

	@Override
	public int calPrice(int price) {	//가격만큼 적립금 추가
		this.bonusPoint += price* bonusRatio;
		return (int)(price*(1-saleRatio));
		//return (int)(super.calPrice(price)*(1-saleRatio)); //윗 두줄 합친것
	}
	public double getsaleRatio() {
		return saleRatio;
	}
	public void setsaleRatio(double saleRatio) {
		this.saleRatio = saleRatio;
	}
}
