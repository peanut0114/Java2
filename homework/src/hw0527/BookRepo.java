package hw0527;
/*
 * book 저장소 
 * BookAccsee를 구현
 */
public class BookRepo implements Repo {
	
	private Book[] list;
	private int index;
	
	// 싱글톤
	private static BookRepo instance = new BookRepo();
	public static BookRepo getInstance() {
		return instance;
	}
	///////
	private BookRepo() {
		init();
	}


	// 메소드
	public void init() { // 초기화
		list = new Book[100];
		index = -1;
	}

	@Override
	public void insert(Book book) {
		list[++index] = book;
	}

	@Override
	public void update(Book book) {
		Book temp = new Book();
		for (int i = 0; i <= index; i++) {
			if (list[i].getIsbn() == book.getIsbn()) {
				temp = list[i];
			}
		}
	}

	@Override
	public void delete(Book book) {
		for (int i = 0; i <= index; i++) {
			if (list[i] == book) {
				list[i] = null;
			}
		}
		cleanNull();
	}

	public void cleanNull() {	//null공간 지우고 땡겨서 정리
		Book temp[] = list;
		int tempindex = index;
		init();
		for (int i = 0; i <= tempindex; i++) {
			if (temp[i] != null) {
				list[++index] = temp[i];
			}
		}
	}


	@Override
	public Book[] selectAll() {
		Book[] temp = new Book[index + 1];
		for (int i = 0; i <= index; i++) {
			temp[i] = list[i];
		}
		return temp;
	}
	
	@Override
	public Book selectOne(int isbn) {
		Book book = new Book();
		for (int i = 0; i <= index; i++) {
			if (list[i].getIsbn() == isbn) {
				book = list[i];
			}
		}
		return book;
	}
}
