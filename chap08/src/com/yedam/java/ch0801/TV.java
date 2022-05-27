package com.yedam.java.ch0801;
/*
 * Control 인터페이스를 상속하는 TV
 */
public class TV implements Control{
	//구현클래스가 필수적으로 가지는 변수지만 인터페이스에서 못 적기때문에 구현클래스에서 공통으로 겹치는 부분생김
	private int volume;
	
	//인터페이스의 추상메소드 전부 재정의해야함
	
	@Override 	//Remote
	public void turnOn() {
		System.out.println("TV를 켭니다.");
	}

	@Override	//Remote
	public void turnoff() {
		System.out.println("TV를 끕니다.");
	}

	@Override	//Remote
	public void setVolume(int volume) {
		if(volume>RemoteControl.MAX_VOLUME) {
			this.volume=RemoteControl.MAX_VOLUME;
		}else if(volume<RemoteControl.MIN_VOLUME) {
			this.volume=RemoteControl.MIN_VOLUME;
		}else {
			this.volume = volume;
		}
		System.out.println("현재 TV 볼륨 : "+this.volume);
	}

	@Override	//Smart
	public void searchInternet(String url) {
		System.out.println(url+"을 검색합니다.");
	}

	@Override	//Smart
	public void executeApp(String app) {
		System.out.println(app+"을 실행합니다.");
	}

	@Override	//Control
	public void plusService() {
		System.out.println("Control 추가 기능을 실행합니다.");
	}

}
