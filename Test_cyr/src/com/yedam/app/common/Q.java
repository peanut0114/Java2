package com.yedam.app.common;

public class Q {
/*
 
 	1. DB에 접근하는 DAO 만들기
 	2. 접근하는 곳의 VO 객체 생성
 	
 	 
 	<패키지 정보>
 	* app : 전체 프로그램 돌리는 곳
 	 
 	* Commom :모든 클래스에서 공통적으로 사용하는 부분 생성
		ex> DB자체를 관리
			동일 DB에 있는 테이블인데 JDBC_02의 emp와 dep처럼 나눠져있으면 따로 수정해야함
	
	
	<클래스정보>
	
	0. DAO :  Oracle(DB) 연결 및 연결해제
	
	1. VO 객체
		* product : productId, productName, productPrice (상품기본정보)
		* history : productId, productCategory, productAmount (재고관리)
	
   	  	-> 통합정보 게터,세터
		* Info : productId, productName, productCategory, productAmount (상품이름 + 재고)
	
	2. DAO 상속받는 클래스 : 싱글톤 + CRUD 작업
		* ProductDAO : DB Product table 컨트롤
			수정 - 가격

		* HistoryDAO : DB Product_history table 컨트롤
			수정 - 입고량/출고량
			조회 - 재고 (서브쿼리사용)
	
	 
 */
}
