package com.yedam.java.example1;

public class RoundRobin implements Scheduler {
	//상담원에게 동일하게 업무를 배분
	@Override
	public void getNextCall() {
		System.out.println("상담 전화를 순서대로 대기열에서 가져옵니다.");
	}

	@Override
	public void sendCallToAgent() {
		System.out.println("다음 순서 상담원에게 배분합니다.");
	}

}
