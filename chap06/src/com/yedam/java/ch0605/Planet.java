package com.yedam.java.ch0605;
/*
 * final 필드 
 * 초기화 후 수정불가. 절대불변
 * 281p
 */
public class Planet {
	//필드
	final int radius;	
	static final double pi = 3.14159;	//static 누구나 볼 수 있음, final 초기화 후 수정불가
	
	//생성자
	Planet(int radius){
		this.radius = radius;	//값초기화
	}
	
	//메소드
	void getArea() {
		double result = 4*Planet.pi*this.radius*this.radius;
		System.out.printf("행성의 표면적  : %.2f",result);
	}
}
