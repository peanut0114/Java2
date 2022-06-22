package com.yedam.app.common;

public class SQLdeveloper {
/*
 1. product 테이블생성
 
	CREATE TABLE products (
    product_id NUMBER PRIMARY KEY,
    product_name  VARCHAR2(100) NOT NULL,  
    product_price NUMBER NOT NULL,
    product_stock NUMBER DEFAULT 0);
 
 
 2. receiving_goods 입고내역 테이블 생성
 
 	CREATE table receiving_goods(
    deal_date DATE DEFAULT sysdate,
    product_id NUMBER,
    product_amount NUMBER);
 
 	ALTER TABLE receiving_goods
	ADD CONSTRAINT pro_fk_receive
	FOREIGN KEY(product_id)
	REFERENCES products(product_id);
 
 
 3. take_out_goods 출고내역 테이블 생성
 
 	CREATE TABLE take_out_goods(
 	deal_date DATE DEFAULT sysdate,
    product_id NUMBER,
    product_amount NUMBER);

	ALTER TABLE take_out_goods
	ADD CONSTRAINT pro_fk_take_out
	FOREIGN KEY(product_id)
	REFERENCES products(product_id);
	
	
 4. 시퀀스 생성
 
	CREATE SEQUENCE products_seq
	INCREMENT BY 1
	START WITH 1
	MINVALUE 1
	MAXVALUE 9999
	NOCYCLE
	NOCACHE;
 
 
 5. members 권한 정보 갖는 테이블
 
 	CREATE TABLE members(
	member_id VARCHAR2(100) PRIMARY KEY,
	member_password VARCHAR2(100) NOT NULL,
	member_role NUMBER(1) DEFAULT 1				--권한 0 : 관리자, 1 : 일반사원
	);	
 
 	INSERT INTO members VALUES ('admin','admin',0);	--관리자 계정 미리 생성
 	INSERT INTO members(member_id, member_password) VALUES ('user1','user1'); --회원계정
 
 */
}
