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
		if(index+1<list.length) {	//빈칸이 적어도 하나 필요(같으면x)
			return true;
		}else {
			return false;		//상품 총 갯수 초과하는 입력 막음
		}
	}
	// 2. 상품 및 가격 입력
	public void putProduct(String name, int price) {

		Product product = new Product(); // 임시변수
		product.setName(name);
		product.setPrice(price);

		list[++index] = product;	//리스트에 저장
	}

	// 3. 제품별 가격 출력
	public void printList() {
		for (int i = 0; i <= index; i++) {
			// System.out.println(list[i].getName()+" : "+list[i].getPrice());
			list[i].showInfo();
		}
	}

	// 4-1. 최고 가격을 가지는 제품 (최고가격은 무조건 한개)
	public Product maxProduct() { // 최댓값구하기
		Product product = new Product();	//임의변수
		//product.setPrice(list[0].getPrice());	//list첫번째 가격을 변수의 가격으로 넣어줌
		product = list[0];
		for (int i = 1; i <= index; i++) {	
			if (product.getPrice() < list[i].getPrice()) {
				//product.setPrice(list[i].getPrice());		//setter로 더 큰값 입력
				//product.setName(list[i].getName());		//max값의 이름도 저장
				product=list[i];							//걍 바로 product로 전부저장
			}
		}
		return product;
	}
	
	// 4-2. 최고 가격을 제외한 제품들의 총합
	public int findtotal() {
		int total = 0;
		//for (int i = 0; i <= index; i++) {
		//	total += list[i].getPrice();	
		for (Product temp:list) {	
			total += temp.getPrice();
		}
		total -= maxProduct().getPrice();	//생성자.메소드 (최댓값빼기)
		return total;
	}
	
	// 4-2-2. 다른형태로 : 향상된 for문 (list크기만큼 돌림)
	public int findtotal2() {
		int total = 0;
		for (Product temp:list) {	
			if(temp.getPrice() == maxProduct().getPrice())	//최댓값일때만 더하기x
				continue;	//break는 반복문 실행x continue 밑의 값은 실행 않고 넘어감.
			total += temp.getPrice();
		}
		return total;
	}
	
	// 4. 분석 출력
	public void printTotal() {
		System.out.print("최고 가격 > ");
		maxProduct().showInfo();			//max값 출력
		System.out.println(maxProduct().getName() + " 제외한 총 합 : " + findtotal());
	}

	// 5. 종료
	public boolean finish() {
		System.out.println("\n종료합니다.");
		return false;
	}
}
