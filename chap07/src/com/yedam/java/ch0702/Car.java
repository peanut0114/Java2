package com.yedam.java.ch0702;
import javax.swing.text.StyledEditorKit.ForegroundAction;
/*
 * 자동차
 */
public class Car {

	//필드
	Tire frontLeftTire = new Tire("앞왼쪽",6);
	Tire frontRightTire = new Tire("앞오른쪽",2);
	Tire backLeftTire = new Tire("뒤왼쪽",3);
	Tire backRightTire = new Tire("뒤오른족",4);
	//생성자
	
	//메소드
	int run() {	//바퀴별로 벙크가 났는지 확인.
		System.out.println("[자동차가 달립니다.]");
		if(frontLeftTire.roll()==false) {	//펑크가 남
			stop();
			return 1;	//펑크 위치 앞왼쪽
		}
		if(frontRightTire.roll()==false) {	//4개가 동시에 돌아야함(else X)
			stop();
			return 2;
		}
		if(backLeftTire.roll()==false) {
			stop();
			return 3;
		}
		if(backRightTire.roll()==false) {
			stop();
			return 4;
		}
		return 0;
	}
	
	void stop() {
		System.out.println("[자동차가 멈춥니다.]");
	}
}
