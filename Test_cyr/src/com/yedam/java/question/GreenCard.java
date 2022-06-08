package com.yedam.java.question;

public class GreenCard implements Payment {

	private String name = "GreenCard";
	private String grade = "SILVER";
	private int point=0;
	private double pointRatio = 0.05;	//포인트 적립율
	
	@Override
	public int offline(int price) {
		this.point+=price*pointRatio;
		return (int) (price * (1- OFFLINE_PAYMENT_RATIO));
	}

	@Override
	public int online(int price) {
		this.point+=price*pointRatio;
		return (int) (price * (1-ONLINE_PAYMENT_RATIO));
	}

	@Override
	public int simple(int price) {
		this.point+=price*pointRatio;
		return (int) (price * (1-SIMPLE_PAYMENT_RATIO));
	}

	@Override
	public void showCardInfo() {
		System.out.println("======= 카드 정보 =======");
		System.out.println("카드명      : "+name);
		System.out.println("적용 등급    : "+grade);
		System.out.println("포인트 적립율 : "+pointRatio);
		System.out.println("적립 포인트  : "+point);
		
	}

}
