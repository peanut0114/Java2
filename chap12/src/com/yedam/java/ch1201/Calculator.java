package com.yedam.java.ch1201;

//공유클래스 -> 동기화메소드 이용

public class Calculator {
	private int memory;

	public int getMemory() {
		return memory;
	}

	/*
	 * 인스턴스 안의 메소드가 한번에 하나만 호출되는게 아니라 여러 스레드에서 호출됨
	 * 출력만 할 때는 상관없지만 필드에 접근하면 문제가 발생
	 * 동시에 필드 접근시 각각이 업데이트 한 값이 유지가 안 됨 돌려받기도 전에 값이 변경
	 * 
	 * -> 필드를 건드리는 메소드에 한해 동기화 메소드를 거는게 좋음!
	 * 	  : 반환값 앞에 synchronized 붙여줌 -> 순차적으로 접근하게 해줌 (try cathch는 필수아님)
	 */
	public synchronized	void setMemory(int memory) {
		
		this.memory = memory;
		
		// 사용중 얘를 건들지 못하게 얘를 사용하는 스레드를 멈춤
		try {
			Thread.sleep(2000); // 2초동안 여기 접근한 스레드가 정지됨
		} catch (InterruptedException e) {}
		// 정상적 작동시
		// 다른쪽에서 인터럽트가 걸린 스레드에 접근하려고하면 정보 출력
		Thread info = Thread.currentThread();
		System.out.println("현재 스레드 : " + info.getName()+
				" , memory : "+this.memory);
	}
}
