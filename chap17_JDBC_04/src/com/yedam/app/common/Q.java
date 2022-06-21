package com.yedam.app.common;

public class Q {
/*
  	인사관리 계정 접근 (db.properties 확인)
 
 	1. 제품 등록
 	2. 입고 -> 입고 직후 재고
 	3. 출고 -> 출고 직후 재고 (따로 관리)
 	4. 거래내역 조회
 		1)입고내역 2)출고내역 3)한 제품
 	
 
 	* ProductManagement : 제품에 대한 정보를 관리하는 클래스
 	* Management : 재고 관리 (입고, 출고)
 	* ProductInfoManagement / ProductStockManagement : 서브프로그램
 	* 
 	* 전체 : 하나의 프로그램, 
 	* 서브프로그램 : Info와 Stock -> 둘 다 productDAO 접근 필요 (싱글톤.. 하나의 인스턴스를 공유하도록!)
				  하나의 필드 management에서 전부 들고 실질적으로 내용 관리 (유지보수가 쉬워짐)
				  DB에서 하나의 필드 공유할때 그 테이블에 대응되는 클래스를 만들어 관리하면 쉬움
				
 	 
	 		┌-Info-┐ ------>   	ProductDAO				  ┌--Stock--┐
 			|	   |			 (제품정보)				  | (입출고) 	|
 			|	   |		  RecivingGoodsDAO	<------	  |   +     |
 			└------┘		  TakeOutGoodsDAO	<------	  | (제품정보)	|
 														  └---------┘
 														  
 	* DealInfo : 공용 Vo객체
 	* Reciving_goods 테이블 : deal_date, product_id, product_amount -> DealInfo
 	* 
 	* HW : takeOut table을 이용한 takeOutGoodsDAO 생성
 				
 */
}
