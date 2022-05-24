package com.yedam.java.ch0606;
/*
 * getter setter
 * 값을 읽을 때, 값을 줄 때
 * private에 접근
 */
public class Car {
	//필드
	private int speed;		//보통 필드는 private으로 막아버림
	private boolean stop;	//초기화 안 하면 false
	
	//생성자
	
	//메소드
	public int getSpeed() {	//getter. get~으로 시작
		return speed;		//매개변수x
	}
	public void setSpeed(int speed) { //setter.
		if (speed<0) {
			this.speed = 0;
			return;
		}else {
			this.speed = speed;
		}
	}
	
	public boolean isStop() {	//불린 타입은 is로 시작
		return stop;
	}
	public void setStop(boolean stop) {
		this.stop = stop;
		this.speed = 0;
	}
}
