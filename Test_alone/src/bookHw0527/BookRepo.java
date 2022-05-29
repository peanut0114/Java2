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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Book book) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Book book) {
		// TODO Auto-generated method stub
		
	}
	

}
