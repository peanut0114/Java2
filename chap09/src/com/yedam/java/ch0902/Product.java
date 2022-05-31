package com.yedam.java.ch0902;
/*
 * 익명 구현 객체
 */
public class Product{
	//필드
	RemoteControl field = new RemoteControl() {
		//필드
		String message = "스마트TV";
		//메소드
		void print() {
			System.out.println("제품 종류 : "+message);
		}
		@Override
		public void turnOn() {
			print();
			System.out.println("전원을 켭니다.");
		}
		@Override
		public void turnOff() {
			print();
			System.out.println("전원을 끕니다.");
		}
	};
	//생성자

	//메소드
	RemoteControl method1() {
		int volume=30;	//익명 개체 안에서 사용시 final 값을 가짐
		
		RemoteControl var = new RemoteControl() {	//method 생성과 동시에 만들어짐
			//필드
			String message = "Audio";
			//메소드
			void print() {
				System.out.println("제품 종류 : "+message);
			}
			
			@Override
			public void turnOn() {
				print();
				System.out.println("전원을 켭니다.");
				System.out.println("현재 볼륨 : "+volume);
			}
			
			@Override
			public void turnOff() {
				print();
				System.out.println("전원을 끕니다.");
			}
		};
		
		var.turnOn();
		var.turnOff();
		
		return var;	
	}

	void method2(RemoteControl rc) {
		rc.turnOn();
		rc.turnOff();
	}
}
