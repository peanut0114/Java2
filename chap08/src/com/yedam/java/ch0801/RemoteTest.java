package com.yedam.java.ch0801;
/*
 * 만능리모콘
 */
public class RemoteTest {
	public static void main(String[] args) {
		// RemoteControl rc = new TV(); //tv연결
		RemoteControl rc = new Audio();
		rc.turnOn();
		rc.setVolume(5);
		rc.turnoff();

		SmartControl sc = new TV();
		sc.searchInternet("네이버");
		sc.executeApp("구글");
		
		TV tv = new TV();
		tv.turnOn();			
		System.out.println();
///////이렇게 하기 번거로워서 Remotcontrol과 Smartcontrol을 상속하는 control 만듬
		
		Control con = new TV();
		con.turnOn();
		con.executeApp("게임");
	}
}
