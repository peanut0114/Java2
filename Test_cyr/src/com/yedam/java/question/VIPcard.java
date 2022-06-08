package com.yedam.java.question;

public class VIPcard implements Payment{

	private String name = "VIPcard";
	private String grade = "GOLD";
	private double saleRatio = 0.10;	//골드 할인율 
	private int point=0;
	private double pointRatio = 0.03;	//포인트 적립율
	
	@Override
	public int offline(int price) {
		this.point+=price*pointRatio;
		return (int) (price * (1- saleRatio-OFFLINE_PAYMENT_RATIO));
	}

	@Override
	public int online(int price) {
		this.point+=price*pointRatio;
		return (int) (price * (1-saleRatio-ONLINE_PAYMENT_RATIO));
	}

	@Override
	public int simple(int price) {
		this.point+=price*pointRatio;
		return (int) (price * (1-saleRatio-SIMPLE_PAYMENT_RATIO));
	}

	@Override
	public void showCardInfo() {
		System.out.println("====== 카드 정보 ======");
		System.out.println("카드명       : "+name);
		System.out.println("적용 등급    : "+grade);
		System.out.println("할인율       : "+saleRatio);
		System.out.println("포인트 적립율 : "+pointRatio);
		System.out.println("적립 포인트   : "+point);
		
	}

}
