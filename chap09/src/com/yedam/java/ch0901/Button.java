package com.yedam.java.ch0901;
/*
 * 중첩 인 터 페 이 스 (주로 정적 인터페이스 사용)	>보통 외부에 독립적으로 쓰진 않음
 * 
 * 마우스 좌클 우클 : 클릭이냐 더블클릭이냐 드래그냐 동작
 * 				  > 프로그램 세팅에 따라 동작 결과가 달라짐
 */
public class Button {
	
	OnClickListener listener;	
	
	void setOnClickListener(OnClickListener listener) {
		this.listener = listener;
	}
	
	void touch() {
		listener.onClick();
	}
	
	static interface OnClickListener{	//Button과 무조건 관계있는것. 연관성때문에 내부에 넣음
		void onClick();					//Button 클래스 내부적 내용 몰라도 요것만 땡겨서 구현하면 얘를 동작시킬 수 있게 됨
	}
	
}

/*
 인터페이스를 이용해 내부적으로 코드를 짬. 필요하면 땡겨서 결과를 낼 수 있게
 
일반 클래스로 만들시 한번 세팅 수정시 코드 전체를 갈아엎어야함
코드는 유지하면서 여러가지 결과를 보장하기 위함 => 인터페이스 다형성

타입에 맞춰 세팅하고 호출을 해야함
보다 강제성을 띄우기 위해 내부에 인터페이스를 가짐

프로그램을 수정하자>>
오라클의 자바 공식문서에 가면 메소드 어떻게 써야하는지 적어놨음(https://docs.oracle.com/en/java/javase/11/docs/)
중첩인터페이스가 나옴

운영체제(윈도우,맥,리눅스 등등) 안에서 키보드를 쓰고자 하면 인터페이스를 넘겨줌 ->매칭시킴
*/