package com.yedam.java.lifofifo;
/*
 * 후입선출 LIFO 스택:클래스
 */
import java.util.Stack;

public class LifoTest {

	public static void main(String[] args) {
		
		Stack<Integer> box = new Stack<>();	//stack은 클래스임
		
		//순차적 입력
		box.push(100);
		box.push(50);
		box.push(100);
		box.push(10);
		
		//순차적 출력
		while(!box.isEmpty()) {	//메소드 isEmpty이용
			System.out.println("\tbox 값 : "+box.size());
			System.out.println("꺼내온 값 : "+ box.pop());	
			//pop() = get()+remove() : 값 재사용 불가, 꺼내면 사라짐 끝
		}	//입력순과 반대로 출력됨 Last In First Out
		
	}

}
