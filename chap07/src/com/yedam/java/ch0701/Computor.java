package com.yedam.java.ch0701;
/*
 * 좀 더 정확한 계산하는 컴퓨터
 * 메소드 재정의 : 골격은 부모와 동일하게 유지해야함
 * 
 * 만든건지 메소드 재정의를 한건지 헷갈림 > @Override로 표시해줌
 * 자바가 한번 더 꼼꼼히 확인해줌. 부모꺼랑 골격 같은가?
 */

public class Computor extends Calculator {
	
	@Override					
	double areaCircle(double r) {
		System.out.println("Computer 객체");
		return Math.PI*r*r;
	}
	
	void print() {
		super.areaCircle(5);
		areaCircle(5);			//super 없으면 자식인 컴퓨터가 실행됨
	}
	
}
