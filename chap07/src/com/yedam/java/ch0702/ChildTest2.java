package com.yedam.java.ch0702;

/*
 * 부모에서 자식으로 강제형변환
 * instanceof 필수
 */
public class ChildTest2 {

	public static void main(String[] args) {

		GranPa pa = new Father();
		pa.method(); // father의 고유 메소드는 안 보임
		System.out.println();

	//	pa = new Uncle(); // uncle을 들고있는 pa
							// 자바는 타입을 먼저 봄
							// -> GranPa라서 Father로 형변환 오류 안 띄움
							// 하지만 실행하면 !오류!

		if (pa instanceof Father) {// 그래서 수많은 자식들 중 Father인가를 판별해야함

			Father fa = (Father) pa; // 부모pa를 자식형태 fa로 강제형변환
			fa.method();
			fa.method2();	//Father의 고유메소드 사용가능
		} else {
			System.out.println("pa 변수가 가지고 있는 인스턴스는 Father가 아닙니다.");
		}
	}
}
