package hw0527;
/*
 * 정보저장
 * isbn, 책제목, 가격
 */
public class Book {
	//필드
	private static int num = 1000;	//자동할당할 ISBN번호
	private int Isbn;
	private String bookName;
	private int bookPrice;
	
	//생성자
	public Book() {}
	
	public Book(String name, int price) {
		bookName=name;
		bookPrice=price;
		this.Isbn=++num;
	}
	
	//메소드
	public int getIsbn() {
		return Isbn;
	}

	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public int getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}
	
	public String showInfo() {
		return "도서명 : "+bookName+", ISBN : "+Isbn+", 가격 : "+bookPrice+"원";
	}
}
