package com.yedam.homework;

public class ProductSystem {

	private Product[] list; // product 배열
	private int index;

	public ProductSystem() {
		index = -1;
	}

	// 1. 전체상품 수 입력
	public void setListSize(int size) {
		list = new Product[size];
	}
	// 2-0. 추가입력 확인
	public boolean check() {
		if(index+1<list.length) {
			return true;
		}else return false;
	}
	// 2. 상품 및 가격 입력
	public void putProduct(String name, int price) {

		Product product = new Product(); // 임시변수
		product.setName(name);
		product.setPrice(price);

		list[++index] = product;

	}

	// 3. 제품별 가격 출력
	public void printList() {
		for (int i = 0; i <= index; i++) {
			// System.out.println(list[i].getName()+" : "+list[i].getPrice());
			list[i].showInfo();
		}
	}

	// 4-1. 최고 가격을 가지는 제품
	public Product maxProduct() { // 최댓값구하기
		Product product = new Product();	//임의변수
		product.setPrice(list[0].getPrice());	//list첫번째 가격을 변수의 가격으로 넣어줌
		for (int i = 1; i <= index; i++) {	
			if (product.getPrice() < list[i].getPrice()) {
				product.setPrice(list[i].getPrice());	//setter로 더 큰값 입력
				product.setName(list[i].getName());		//max값의 이름도 저장
			}
		}
		return product;
	}
	// 4-2. 최고 가격을 제외한 제품들의 총합
	public int findtotal() {
		int total = 0;
		for (int i = 0; i <= index; i++) {
			total += list[i].getPrice();	//getter로 price값 가져와서 합하기
		}
		total -= maxProduct().getPrice();	//생성자.메소드
		return total;
	}
	// 4. 분석
	public void printTotal() {
		System.out.print("최고 가격 > ");
		maxProduct().showInfo();			//max값 출력
		System.out.println(maxProduct().getName() + " 제외한 총 합 : " + findtotal());
	}

	// 5. 종료
	public void finish() {
		System.out.println("\n종료합니다.");
	}
}
