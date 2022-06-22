package com.yedam.app.book;
//Books 테이블 VO 클래스
public class Book {
	private String bookName;//책제목
	private String bookWriter;//저자명
	private String bookContent;//책내용
	private boolean bookRental; //0:대여가능, 1:대여불가
	
	//getter, setter
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookWriter() {
		return bookWriter;
	}
	public void setBookWriter(String bookWriter) {
		this.bookWriter = bookWriter;
	}
	public String getBookContent() {
		return bookContent;
	}
	public void setBookContent(String bookContent) {
		this.bookContent = bookContent;
	}
	public boolean isBookRental() {
		return bookRental;
	}
	public void setBookRental(boolean bookRental) {
		this.bookRental = bookRental;
	}
	
	@Override
	public String toString() {
		String info = "책제목 : " + bookName + ", 저자명 : " + bookWriter
				+", 내용 : " + bookContent + ", 대여여부 : ";
		if(!bookRental) {	//0 대여가능
			info += "대여가능";
		}else {				//1 대여불가
			info += "대여중";
		}
		return info;
	}



}
