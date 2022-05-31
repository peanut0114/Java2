package bookHw0527;

public class BookRepo implements Access{
	
	private Book[] list;
	private int index = -1;
	
	//싱글톤
	private static BookRepo instance = new BookRepo();
	public BookRepo getInstance() {
		return instance;
	}
	private BookRepo() {}
	
	@Override	//저장소에 저장
	public void insert(Book book) {
		list[++index]=book;
	}

	@Override
	public Book[] printAll() {
		Book temp[] = list;
		int tIndex = index;
		list=null;
		return list;
	}

	@Override
	public Book printOne(int isbn) {
		Book select = new Book();
		for(int i=0 ; i<=index ; i++) {
			if(isbn==list[i].getIsbn()) {
				select=list[i];
			}
		}
		return select;
	}

	@Override
	public void update(Book book) {
		for(int i=0 ; i<=index ; i++) {
			if(book.getBookPrice()==list[i].getIsbn()) {
				list[i]=book;
			}
		}
	}

	@Override
	public void delete(Book book) {
		for(int i=0 ; i<=index ; i++) {
			if(book.getBookPrice()==list[i].getIsbn()) {
				list[i]=null;
			}
		}
		cleanNull();
	}
	
	public void cleanNull() {
		Book[] temp = list;
		int tempindex = index;
		index=-1;
		list=null;
		for(int i=0;i<=tempindex;i++) {
			if(temp[i]!=null) {
				list[++index]=temp[i];
			}
		}
		
	}

}
