package com.yedam.java.ch0605;

public class PlanetTest {

	public static void main(String[] args) {

		System.out.println("pi : "+Planet.pi);
		//Planet.pi = Math.pi;	//값 변경 불가
		
		Planet earth = new Planet(6400);	//딱 한 번 값 입력
		//earth.radius = 6000;				//한번 값 넣었기에 수정 불가능
		System.out.println("earth : " + earth.radius);	
		Planet moon = new Planet(1500);		//인스턴스 별로 다르게 입력 가능
		System.out.println("moon : " + moon.radius);	
		
		System.out.print("earth ");
		earth.getArea();
	}

}
