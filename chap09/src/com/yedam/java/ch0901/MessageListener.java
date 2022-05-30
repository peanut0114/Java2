package com.yedam.java.ch0901;
/*
 * 버튼 동작식 전화를 걸도록
 * Button의 중첩인터페이스 구현
 */
public class MessageListener implements Button.OnClickListener{

	@Override
	public void onClick() {
		System.out.println("메세지를 보냅니다.");
	}

	
}
