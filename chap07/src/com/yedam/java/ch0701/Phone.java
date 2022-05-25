package com.yedam.java.ch0701;
/*
 * 오버라이딩
 * 317p
 */
public class Phone {
	//필드
	String model;
	String color;
	
	//생성자 만들면 자식클래스에서 super X 
	public Phone(String model, String color) {
		this.model = model;
		this.color = color;
	}
	
	//메소드
	final void powerOn() {
		System.out.println("전원을 켭니다.");
	}
	final void powerOff() {
		System.out.println("전원을 끕니다.");
	}
	protected void bell() {
		System.out.println("벨이 울리고 진동을 일으킵니다.");
	}
	
	void call() {
		System.out.println("통화를 합니다.");
	}
	private void print() {
		System.out.println("테스트");
	}
	
}
