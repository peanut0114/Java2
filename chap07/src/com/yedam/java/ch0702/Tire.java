package com.yedam.java.ch0702;
/*
 * 자동차 부품
 */
public class Tire {

	//필드
	public int maxRotation;	//타이어수명(최전수)
	public int accumulatedRotation; //누적회전수
	public String location;	//타이어의 위치
	
	//생성자
	public Tire (String location, int maxRotation) {
		this.location = location;
		this.maxRotation = maxRotation;
	}
	
	//메소드
	public boolean roll() {
		++accumulatedRotation;	//최전수 증가
		if(accumulatedRotation < maxRotation) {	
			System.out.printf("%s Tire 수명 : %d\n",location,maxRotation-accumulatedRotation);
			return true;
		}else {	
			System.out.printf("*** %s Tire 펑크 ***\n",location);
			return false;
		}
	}
}
