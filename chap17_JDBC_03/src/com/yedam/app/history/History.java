package com.yedam.app.history;
/*
 * product history에 접근
 */
public class History {
	private int productId;
	//각 컬럼의 제약조건 있음(check) 오라클은 불린없음 -> 0/1 이용해서 구분
	//1 : 입고, 2 : 출고
	private int productCategory;
	private int productAmount;
	
	//toString 오버라이딩 안 함 (이 클래스 정보만 출력할 일이 없음)
	
	//getter, setter
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(int priductCategory) {
		this.productCategory = priductCategory;
	}
	public int getProductAmount() {
		return productAmount;
	}
	public void setProductAmount(int productAmount) {
		this.productAmount = productAmount;
	}
	
	

}
