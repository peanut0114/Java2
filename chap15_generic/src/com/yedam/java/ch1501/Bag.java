package com.yedam.java.ch1501;
/*
 * 모든 타입을 담을 수 있는 클래스
 */
public class Bag {
	
	private Object object;	//최상위 클래스로 선언햇음
	
	//getter setter
	public void set(Object object) {
		this.object = object;
	}
	
	public Object get() {
		return object;
	}
}
