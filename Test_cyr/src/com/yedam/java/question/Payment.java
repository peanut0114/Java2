package com.yedam.java.question;

public interface Payment {

	static double OFFLINE_PAYMENT_RATIO = 0.01; //오프라인 1%
	static double ONLINE_PAYMENT_RATIO = 0.03;	//온라인 3%
	static double SIMPLE_PAYMENT_RATIO = 0.05;	//간편결제 5%
	
	public int offline(int price) ;
	public int online(int price);
	public int simple(int price);
	public void showCardInfo();
}
