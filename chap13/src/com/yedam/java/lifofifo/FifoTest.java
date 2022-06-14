package com.yedam.java.lifofifo;
/*
 * 선입선출 FIFO 큐 
 */
import java.util.LinkedList;
import java.util.Queue;

public class FifoTest {

	public static void main(String[] args) {
		Queue<Integer> que = new LinkedList<>(); // 큐를 구현하는 링크드리스트

		que.offer(100);	//순차적 입력
		que.offer(50);
		que.offer(100);
		que.offer(10);

		while (!que.isEmpty()) {
			int value = que.poll();
			System.out.println("\tbox 값 : " + que.size());
			System.out.println("꺼내온 값 : " + value);	//입력 순서와 동일한 출력
		}
	}
}
