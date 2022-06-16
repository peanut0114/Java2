package com.yedam.app.product;
//VO클래스
public class Product {
	//필드
	private int productId;
	private String productName;
	private int productPrice;
	
	@Override
	public String toString() {
		return "제품번호 : "+productId
				+", 제품명 : "+productName
				+", 가격 : "+ productPrice;
	}
	
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
	
	
}
