package com.yedam.java.list;

import java.util.List;

/*
 * Thread를 상속받는 ThreadA
 */
public class ThreadA extends Thread {
	private List<Integer> list;
	
	public void setList(List<Integer> list) {
		this.list = list;
	}

	@Override
	public void run() {
		for(int i=0 ; i<10;i++) {
			list.add(1+i);
		}
		for(int data : list) {
			System.out.println(Thread.currentThread().getName()+":"+data);
		}
	}

}
