package com.yedam.example2;
/*
 * 싱글톤
 * 정보의 일관성을 위함. 카드발급 본사
 * 외부에서 생성자 생성x
 */
public class CardFactory {
	
	//필드
	private static CardFactory instance = new CardFactory();
	
	//생성자
	private CardFactory() {} //클래스 내부에서만 사용
	
	//메소드
	public static CardFactory getInstance() {
		return instance;
	}
	//////////////////////////////////////////////////////////여까지 싱글톤 생성
	
	public Card createCard() {		//실제 기능 (static x : 인스턴스 거치지 않고는 수행x)
		return new Card();
	}
}
