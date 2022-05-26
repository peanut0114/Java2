package com.yedam.java.ch0703;
/*
 * 추상 클래스 : 특성 모아둠
 * 단독으로 인스턴스 생성 불가
 * 
 * 추상클래스 안에 추상메소드가 필수는 아님
 * 하지만 추상메소드가 존재한다면 추상클래스여야 함
 */
public abstract class Phone {
	//필드
	public String model;
	public String color;
	
	//생성자
	public Phone(String model, String color) {
		this.model = model;
		this.color = color;
	}
	
	//메소드
	
	//같은 동작 : 일반 메소드
	public void powerOn() {
		System.out.println("전원을 켭니다.");
	}
	public void powerOff() {
		System.out.println("전원을 끕니다.");
	}
	//각자 다른 동작 : 추상 메소드
	public abstract void bell();	//추상메소드. 실행블록{} 없음
									//실체클래스가 내용을 정의해줘야 함
}
