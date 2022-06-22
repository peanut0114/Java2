package com.yedam.app.common;

public class Q2 {
/*
 
 	추가기능 : 로그인 정보에 따른 권한 분류 (유저 정보 저장한는 테이블 member 생성)
 	
 	기능 실행 권한 			익명 		< 	일반		< 	관리자 
 					  		
 				  		단순조회  		장바구니		반품,환불 처리
 									구입			제품 등록,추적,삭제
 								
 	1.로그인시 분류 :		A클래스		B클래스		C클래스			
 	  ->완전 독립된 형태
 	   (권한 무시하며 
 	   다른 메뉴 실행불가)
	
	2. 클래스 내부에서
		권한에 따른	:	통합 클래스 내에서 기능분류
	  접속메뉴 구분			클래스별 조회가 중복될 가능성 있음
 	
 	
 */
}