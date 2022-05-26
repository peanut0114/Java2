package com.yedam.java.ch0702;

public class HankookTire extends Tire {

	public HankookTire (String location, int maxRotation) {
		super(location,maxRotation);
	}
	
	@Override
	public boolean roll() {
		++accumulatedRotation;	//최전수 증가
		if(accumulatedRotation < maxRotation) {	
			System.out.printf("%d HanKookTire 수명 : %d",location,maxRotation-accumulatedRotation);
			return true;
		}else {	
			System.out.printf("*** %d HanKookTire 펑크 ***",location);
			return false;
		}
	}
}
