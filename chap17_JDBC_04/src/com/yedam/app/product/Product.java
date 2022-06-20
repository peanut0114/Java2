package com.yedam.app.product;
//VO
public class Product {

	//필드
	private int productId;
	private String productName;
	private int productPrice;
	private int productStock;
	
	//getter, setter
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	public int getProductStock() {
		return productStock;
	}
	public void setProductStock(int productStock) {
		this.productStock = productStock;
	}
	
	@Override
	public String toString() {
		return "제품번호 : " + productId
			+", 제품명 : " + productName 
			+", 가격 : " + productPrice
			+", 재고 : " + productStock
			+", 현 재고기반 가치 : "+(productPrice*productStock);	//필요한 정보 연산으로 출력(괄호필수)
	}
	
	
}
