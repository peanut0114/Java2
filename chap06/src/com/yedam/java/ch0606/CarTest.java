package com.yedam.java.ch0606;

public class CarTest {

	public static void main(String[] args) {

		Car myCar = new Car();
		
		//myCar.speed = -50;
		myCar.setSpeed(-50);	//값을 줄때
		
		System.out.println("현재 속도 : "+myCar.getSpeed());	//값을 읽을때
		
		myCar.setSpeed(50);
		System.out.println("현재 속도 : "+myCar.getSpeed());
		
		if(!myCar.isStop()) {		//stop이 false면 강제로 true로 돌려줌
			myCar.setStop(true);	//멈춤
		}
		
		System.out.println("현재 속도 : "+myCar.getSpeed());
	}

}
