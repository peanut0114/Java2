package com.yedam.java.ch0602;
/*
 * 생성자로 값 초기화!
 * 각각에 값을 넣어도 새로 만들면 덮어씀
 */
public class Car {	// 생성자 내에서 필드, 메소드, 또다른 생성자 호출 가능
	// 필드
	String company = "현대자동차";
	String model = "그랜져";
	String color = "검정";
	int maxSpeed = 350;
	int speed;

	Car() {} // 기본생성자 : 자바가 만들어줌(클래스 내에 생성자가 없어야함)
			// 보통은 항상 선언할것
			// 인스턴스를 만들겠다. 클래스건드는것x

	Car(String color) { // 생성자
		this.color = color; // 클래스 내부에서만 사용 가능.
		//this.필드 : 인스턴스를 가리킴
	}
	
	//Car(String model){}	//매개변수 타입과 순서 같은게 있으면 X

	Car(String model, String color) {
		//this.model = model;
		//this.color = color;
		this(model,color,350);	
		/* this : 
		 * 생성자를 뜻함 (this.필드) (this.메소드)
		 * 동일한 매개변수를 가지는 생성자를 불러옴(재호출)
		 * -> 받은 모델, 컬러값과 지정해준 350 들고 밑의 생성자(3개변수)로 달려감
		 * 반드시 생성자 내 가장 첫 줄에 와야 함 (인스턴스를 생성하는것이기 때문에 초기화 전에 생성!)
		 */
		company="기아"; //this 위에 못 씀
	}
	
	Car(String model, String color, int maxSpeed) {
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;
	}
}
