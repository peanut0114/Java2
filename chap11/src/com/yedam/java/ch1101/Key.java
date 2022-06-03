package com.yedam.java.ch1101;

public class Key {

	public int number;
	
	public Key(int number) {
		this.number = number;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Key) {
			Key key = (Key)obj;
			if(number== key.number) {	//필드 값이 같으면 논리적으로 같다고 출력
				return true;
			}
		}
		return false;
	}

	@Override
	public int hashCode() {	
		return number;			//필드가 같으면 동등해지게 필드값 리턴
	}

	@Override
	public String toString() {	//보통의 형태 :어느 클래스의 어느 필드값이 ~~입니다.
		return "Key [number=" + number + "]";	//프로젝트 할때는 사용자 보기 쉽게 짜야함
	}
	
	
}
