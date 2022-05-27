package com.yedam.java.ch0802;
/*
 * 매개변수의 다형성
 */
public class DriverTest {
	public static void main(String[] args) {
		Driver driver = new Driver();	//자동차 운전을 할 줄 아는 사람을 불러옴
		
		Taxi taxi = new Taxi();	//택시와 버스 두대 준비함
		Bus bus = new Bus();	//서로 다른 클래스
		
		driver.drive(taxi);	//drive에 두개의 매개변수 입력가능
		driver.drive(bus);	//사용밥법을 따르고있음 
		
	}
}
