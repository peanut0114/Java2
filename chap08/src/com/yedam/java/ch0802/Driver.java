package com.yedam.java.ch0802;
/*
 * 직접적인 관계 X 사용관계
 */
public class Driver {
	void drive(Vehicle vehicle) {
		if(vehicle instanceof Bus) {	//문법상으로 문제는 없지만 실행시 생기는 문제 방지
			Bus bus = (Bus)vehicle;		//버스만의 기능을 쓰기위해 강제형태변환
			bus.checkFare();
		}
		
		vehicle.run();				//운전방법 호출	
	}
}
