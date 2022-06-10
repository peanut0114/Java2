package com.yedam.java.ch1601;

public class MainTest {

	public static void main(String[] args) {
//람다식 익명객체 기본형태--------------------------------------------------------
		MyFunctionalInterface fi = () -> { System.out.println("람다식 실행");};
		//람다식 하나에 대해 정의										객체
		//new연산자를 쓰지 않았지만 이 내용을 기반으로 하는 method를 가진 fi인스턴스
		
		fi.method();
		
//정석의 익명객체 (기존에 쓰던 방식) -----------------------------------------------
		MyFunctionalInterface mfi = new MyFunctionalInterface() {
			//반드시 구현해야하 하는 부분이 이 한곳 (메소드 정의)
			@Override
			public void method() {
				System.out.println("익명 구현 객체 실행");
			}
		};
		mfi.method();

	}

}
