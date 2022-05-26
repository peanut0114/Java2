package com.yedam.java.ch0702;

public class KumhoTire extends Tire{

	public KumhoTire (String location, int maxRotation) {
		super(location,maxRotation);
	}
	
	@Override
	public boolean roll() {
		++accumulatedRotation;	//최전수 증가
		if(accumulatedRotation < maxRotation) {	
			System.out.printf("%d KumhoTire 수명 : %d",location,maxRotation-accumulatedRotation);
			return true;
		}else {	
			System.out.printf("*** %d KumhoTire 펑크 ***",location);
			return false;
		}
	}
}
