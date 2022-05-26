package com.yedam.java.ch0702;

public class DriverTest {

	public static void main(String[] args) {
		Driver driver = new Driver();
		/*
		Bus bus = new Bus();	인스턴스 선언시 변수 선언 but 필수x 
		dirver.drive(bus);		한번만 쓸거면 선언 필요x
		bus.run();				개별적으로 사용하려면 선언o
		*/
		driver.drive(new Bus());	//매개변수로 선언해 놓은게 있음. 바로 선언해도 무방
		driver.drive(new Texi());	//타입변환 + 동일한 메소드가 있어서 실행됨 -> 다양성
		driver.drive(new Vehicle());
	}
}
