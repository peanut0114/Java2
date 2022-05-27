package com.yedam.java.example01;

public class Vip extends Customer {

	public double saleRatio;	//할인율
	public String countselor;	//전문 상담원
	
	public Vip() {
		this.customerGrade = "VIP";
		this.bonusRatio = 0.05;
		this.saleRatio = 0.15;
		this.countselor= "이한나";
	}
	public Vip(int customerId, String customerName,String countselor) {
		super(customerId, customerName);
		this.customerGrade = "VIP";
		this.bonusRatio = 0.05;
		this.saleRatio = 0.15;
		this.countselor= countselor;
	}
	
	@Override
	public int calPrice(int price) {	//가격만큼 적립금 추가
		this.bonusPoint += price* this.bonusRatio;
		return (int)(price*(1-saleRatio));
	}

	@Override
	public String showInfo() {
		return super.showInfo()+"\n"+"담당 상담원은 "+countselor +"입니다.";
	}
	
	public void setSaleRatio(double saleRatio) {
		this.saleRatio = saleRatio;
	}
	public double getSaleRatio() {
		return saleRatio;
	}
	public void setCountselor(String person) {
		this.countselor = person;
	}
	public String getCountselor() {
		return countselor;
	}
}
