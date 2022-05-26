package com.yedam.java.example01;
/*
 * 고객정보를 저장하는 저장소
 */
public class Repo {
	// 필드
	private Customer[] dataList;
	private int listIndex;

	// 생성자
	public Repo() {
		dataList = new Customer[100];
		listIndex = -1;
	}

	// 메소드

	// 등록
	public void insert(Customer customer) {
		dataList[++listIndex] = customer;
	}

	// 수정
	public void update(Customer customer) {
		for (int i = 0; i <= listIndex; i++) {
			if (dataList[i].getCustomerId() == customer.getCustomerId()) {
				dataList[i] = customer;
			}
		}
	}

	// 삭제
	public void delete(int customerId) {
		for (int i = 0; i <= listIndex; i++) {
			if (dataList[i].getCustomerId() == customerId) {
				dataList[i] = null;
			} // 중간이 비면 오류 생김. 실제 사용은 x
		}
	}

	// 데이터정리
	private void cleanDataList() { // 밖에서 호출할 일이 없으므로 private으로 막아줌
		// 기존 데이터, 임시 변수에 복사
		Customer[] temp = dataList;
		int tempIndex = listIndex;

		// 기존 데이터를 초기화
		this.dataList = new Customer[100];
		this.listIndex = -1;
		for (int i = 0; i <= tempIndex; i++) {
			if (temp[i] == null) {
				continue; // 비어있으면 건너뛰고 처음부터 다시 넣음
			}
			dataList[++listIndex] = temp[i];
		}
	}

	// 조회
	public Customer[] selectAll() { // 배열 전체를 넘겨줘서 확인해라~
		return dataList;
	}

	public Customer selectOne(int customerId) {
		Customer selected = null;
		for (int i = 0; i <= listIndex; i++) {
			if (dataList[i].getCustomerId() == customerId) {
				selected = dataList[i];
				break;
			}
		}
		return selected;
	}

}
