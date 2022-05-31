package bookHw0527;

public class Book {
	//필드
	private static int serial = 1000;
	private int isbn;
	private String bookName;
	private int bookPrice;

	//생성자
	public Book() {}
	
	public Book(String name,int price) {
		bookName = name;
		bookPrice = price;
		isbn = ++serial;
	}

	//메소드
	public static int getSerial() {
		return serial;
	}

	public static void setSerial(int serial) {
		Book.serial = serial;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
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
	
	
}
