package com.yedam.java.ch0701;
/*
 * phone을 상속중
 * 
 * tv를 보는 dmb폰
 * phone을 부모 클래스로 두는 자식 클래스 DmbPhone
 */
public class DmbPhone extends Phone {	

	int ch;
	
	public DmbPhone(String model, String color){	//인스턴스가 부모꺼도 같이 만들어짐
		//super();	//default 생성자 자바가 만들어놓음. this는 내꺼부모꺼모두, 부모꺼는 super
		super(model, color);
		//this.model = model;			//객체는 따로 존재하지만 연결되어있어서
		//super.color = color;			//부모클래스꺼를 내꺼처럼 접근해서 사용
		this.ch = 10;
	}
	
	void turnOnDmb() {	
		System.out.println("채널"+ch+"번 방송 수신을 시작합니다.");
	}
	
	void turnOffDmb() {
		System.out.println("방송 수신을 멈춥니다.");
	}

	void changeChannel(int ch) {
		this.ch = ch;
		System.out.println("채널"+ch+"번으로 바꿉니다.");
	}
	
	@Override
	protected void bell() {
		// TODO Auto-generated method stub
		super.bell();
	}
	
	@Override
	void call() {
		// TODO Auto-generated method stub
		super.call();
	}
	
}
