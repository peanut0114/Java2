package com.yedam.example2;

public class Card {
	//필드
	private static int serialNo = 1100;
	private int cardNo;
	private String name;
	
	//생성자
	public Card() {
		this.cardNo = ++serialNo;
	}
	public Card(String name) {
		this.name = name;
		this.cardNo = serialNo++;
	}
	
	//메소드
	public static int getSericlaNo() {
		return serialNo;
	}
	public int getCardNo() {
		return cardNo;
	}
	public String getName() {
		return name;
	}
}
