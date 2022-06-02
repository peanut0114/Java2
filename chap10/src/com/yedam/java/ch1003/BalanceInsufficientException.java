package com.yedam.java.ch1003;
/*
 * 잔액부족 예외클래스를 만들어보자
 * 생성자2개
 */
public class BalanceInsufficientException extends Exception { //예외클래스 상속 필수
	public BalanceInsufficientException() {
		
	}
	public BalanceInsufficientException(String message) {
		super(message);	//필요에 따른 오류 메세지 넘기기
	}

}
