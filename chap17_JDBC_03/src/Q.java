
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
	1. 싱글톤 + CRUD 작업
	* product : productId, productName, productPrice
	* history : productId, productCategory, productAmount
	
	2. 통합정보 게터,세터
	* Info : productId, productName, productCategory, productAmount
	
	* ProductDAO 
		수정 - 가격

	* HistoryDAO 
		수정 - 입고량/출고량
		조회 - 재고 (서브쿼리사용)
	
	 
 */
}
