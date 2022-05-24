package com.yedam.example;

public class TakeTrans {

	public static void main(String[] args) {

		Student hong = new Student("Hong",5000);
		Subway green = new Subway("2호선",1500);
		Bus blue = new Bus("306",1400);
		
		hong.take(green);
		hong.take(blue);
		
		hong.showInfo();
		green.showInfo();
		blue.showInfo();
	}

}
