package com.yedam.java.ch0602;

public class Main {

	public static void main(String[] args) {

		Car myCar = new Car();
		System.out.println(myCar.company);	//클래스 내의 필드값 그대로 가져옴
		System.out.println(myCar.model);
		System.out.println(myCar.color);
		System.out.println(myCar.maxSpeed);		
		myCar.speed = 100;
		System.out.println(myCar.speed);
		
		Car yourCar = new Car();
		System.out.println(yourCar.company);
		System.out.println(yourCar.model);
		System.out.println(yourCar.color);
		System.out.println(yourCar.maxSpeed);
		System.out.println(yourCar.speed);
		
		Car blueCar = new Car("Blue");		//클래스 자체는 건드리지 않음
		System.out.println(blueCar.color);	//각각의 값을 줌
		
		Car newCar = new Car();
		System.out.println(newCar.color);
		
	}
}
