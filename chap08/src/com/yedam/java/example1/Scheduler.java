package com.yedam.java.example1;

public interface Scheduler {
	//직원이 고객을 할당받는 방식	//끊고 다음 고객 받아야함
	public void getNextCall();
	
	//관리자가 직접 대기열을 관리 (전화를 직원에게 돌림
	public void sendCallToAgent();
}
