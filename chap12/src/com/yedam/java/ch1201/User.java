package com.yedam.java.ch1201;
/*
 * Calaulator에 접근하는 유저 
 * 자식클래스를 이용해 여러 스레드를 만들 예정
 */

public class User extends Thread{ 	//thread를 상속함
	private static int serial = 0;
	private Calculator cal;
	private int numInfo;
	
	public void setCalculator(Calculator cal) {
		serial+=100;
		this.setName("User"+(serial));	//스레드에 이름을 줌
		this.cal = cal;
		this.numInfo = serial;
	}

	@Override
	public void run() {
		cal.setMemory(100+numInfo);	//run 메소드 안에서 calculator 동작시킴
	}
}
