package com.yedam.java.ch0801;
/*
 * 인터페이스를 상속하는 인터페이스
 * 
 * remote와 smart를 상속하는 control
 * control을 상속하는 tv
 */
public interface Control extends RemoteControl, SmartControl{
//분산된 인터페이스를 하나로 모으거나 자신만의 기능을 갖거나.
//오디오와 관련없음
	public void plusService();
}
