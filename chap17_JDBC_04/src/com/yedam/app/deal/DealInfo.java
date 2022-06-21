package com.yedam.app.deal;
import java.sql.Date;

//receiving_goods 테이블의 VO클래스
public class DealInfo {
	
	//필드
	private Date dealDate;
	private int productId;
	private int productAmount;
	private String productName;	//테이블엔 없는 컬럼
	
	//getter,setter
	
	public Date getDealDate() {
		return dealDate;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public void setDealDate(Date dealDate) {
		this.dealDate = dealDate;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getProductAmount() {
		return productAmount;
	}
	public void setProductAmount(int productAmount) {
		this.productAmount = productAmount;
	}
	
	@Override
	public String toString() {
		String result ="거래일자 : "+dealDate+", 제품번호 : "+productId;
		if (productName!= null) {
			result +=",제품이름 : "+productName;
		}
		result += ", 수량 : "+productAmount;
		return result;
	}
	
	
}
