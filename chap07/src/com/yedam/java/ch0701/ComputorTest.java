package com.yedam.java.ch0701;

public class ComputorTest {

	public static void main(String[] args) {
		
		Calculator cal = new Calculator();
		System.out.println("원 면적 : "+ cal.areaCircle(10));
		
		Computor com = new Computor();
		System.out.println("원 면적 : "+ com.areaCircle(10));
		
		System.out.println();
		
		com.print();
		
	}

}
