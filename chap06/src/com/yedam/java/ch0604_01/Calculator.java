package com.yedam.java.ch0604_01;

/*
 * 1. 숫자 갯수 입력
 * 2. 갯수만큼 숫자 입력받기
 * 3. 더하기
 * 4. 빼기
 * 5. 곱하기
 * 6. 나누기
 */
public class Calculator {

	int[] numList; // 입력받을 숫자 배열
	int index;

	Calculator() {
		index = -1;
	}

	// 1. 갯수입력
	void setArraySize(int size) {
		numList = new int[size];
	}

	// 2. 숫자입력
	void setNum(int num) {
		if (index < numList.length-1) { // index 넘어서는 개수 입력x :0~(index-1)
			numList[++index] = num;
		} else {
			System.out.println("숫자를 더이상 입력할 수 없습니다.");
		}
	}

	// 0. 조건체크 : 값이 최소 2개 이상 입력되었는지 확인
	boolean isExecuted() { // 실행가능?
		if (index + 1 >=2) { // 실제 갯수 확인
			return true;
		} else {
			System.out.println("숫자를 더 입력해주세요.");
			return false;
		}
	}

	// 3. 더하기
	void plus() {
		if (isExecuted()) { // 배열에 들어간 값이 2개 이상인지
			int sum = 0;
			for (int i = 0; i <= index; i++) { // 실제 입력수와 배열 크기가 다를 수 있음
				// 실제 위치 : index이용 (= 들어가야함!)
				sum += numList[i];
			}
			System.out.println("합 : " + sum);
		}
	}

	// 4. 빼기
	void minus() {
		if (isExecuted()) {
			int result = numList[0];
			for (int i = 1; i <= index; i++) {
				result -= numList[i];
			}
			System.out.println("차 : " + result);
		}
	}
	
	//5. 곱하기
	void mult() {
		if(isExecuted()) {
			int result = 1;
			for (int i=0 ; i<=index ; i++) {
				result *= numList[i];
			}System.out.println("곱  : "+ result);
		}
	}
	
	//6. 나누기
	void divide() {
		if(isExecuted()) {
			double result = (double)numList[0];
			for (int i=1 ; i<=index ; i++) {
				result /= (double)numList[i];
			}
			System.out.println("나눔 : "+ result);
		}
	}

}
