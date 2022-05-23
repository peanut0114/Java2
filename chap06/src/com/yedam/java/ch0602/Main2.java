package com.yedam.java.ch0602;

public class Main2 {

	public static void main(String[] args) {

		Car myCar = new Car("Blue");	//이미 생성자가 존재함. 자바가 자동으로 만들지않음
		Car yourCar = new Car ("티볼리","Silver");
		Car newCar = new Car("레이","Yello",120);
				
		System.out.println(myCar.model);
		System.out.println(myCar.color);
		System.out.println(myCar.maxSpeed);
		System.out.println();
		System.out.println(yourCar.model);
		System.out.println(yourCar.color);
		System.out.println(yourCar.maxSpeed);
		System.out.println();
		System.out.println(newCar.model);
		System.out.println(newCar.color);
		System.out.println(newCar.maxSpeed);
		System.out.println();
		
	}

}
