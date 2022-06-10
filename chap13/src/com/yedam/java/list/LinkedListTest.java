package com.yedam.java.list;
/*
 * 컬렉션 프레임 워크
 * List 컬렉션(인터페이스)을 구현하는 클래스 LinkedList
 * : ArrayList와 비슷. 속도 차이가 있음 (인접링크를 체인처럼 관리)
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListTest {

	public static void main(String[] args) {
		// arrayList와 LinkedList의 속도 차이 볼거임 (5배정도 남)
		List<String> list1 = new ArrayList<>();
		List<String> list2 = new LinkedList<>();

		long start;
		long end;

		// ArrayList
		start = System.nanoTime(); // 시작시간
		for (int i = 0; i < 10000; i++) {
			list1.add(0, String.valueOf(i)); // 첫번째 자리에 값 계속 추가
		}
		end = System.nanoTime(); // 종료시간
		System.out.println("ArrayList  걸린 시간 : " + (end - start) + "ns");

		// LinkedList
		start = System.nanoTime(); // 시작시간
		for (int i = 0; i < 10000; i++) {
			list2.add(0, String.valueOf(i)); // 첫번째 자리에 값 계속 추가
		}
		end = System.nanoTime(); // 종료시간
		System.out.println("LinkedList 걸린 시간 : " + (end - start) + "ns");
	}

}
