package hw0527_ver2;
/*
 * book 저장소 
 * Access를 구현
 */
public class BookDAO implements Access {
//필드 - 저장할 공간
	private Book[] list;
	private int index;
	
//생성자 - 싱글톤(일관성 유지 위함)
	private static BookDAO instance = new BookDAO();	//모든 사람이 접근가능한 static형태
	private BookDAO() {		//아무나 수정x private
		init();				//리스트 초기화
	}
	public static BookDAO getInstance() {	//외부에서 접근시 인스턴스 반환
		return instance;
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
		cleanDataList();	//delete의 필수 작업은 아니므로 메서드 분리 (입력때 빈칸 찾아 넣을 수도있음) 기능을 나눔
	}

	public void cleanDataList() {	//null공간 땡겨서 정리
		//기존 필드 -> 임시변수로 값 복사
		Book tempList[] = list;			
		int tempIndex = index;
		//기존 필드 초기화
		init();
		//임시변수 -> 기존 필드로 값을 옮김
		for (int i = 0; i <= tempIndex; i++) {
			if (tempList[i] != null) {
				list[++index] = tempList[i];
			}
		}
	}

	@Override
	public Book[] selectAll() {
		//return list; -> 실제 데이터 크기는 더 작을 수 있음. 
		//index를 따로 넘길 수 없으니 있는 양만큼만 정리해서 만들자
		Book[] temp = new Book[index + 1];	//실제 들어있는 정보 양(index+1) 만큼의 배열을 만듬
		for (int i = 0; i <= index; i++) {	//삭제할때마다 null제거하기때문에 그냥 복사 가능
			temp[i] = list[i];
		}
		return temp;	//뒷부분 공백 뺀 리스트 반환
	}
	
	@Override
	public Book selectOne(int isbn) {
		Book book = null;
		//int bindex =0;
		for (int i = 0; i <= index; i++) {
			if (list[i].getIsbn() == isbn) {
				//bindex=i;
				book = list[i];
				break;
			}
		}
		//return list[bindex];
		return book;
	}
}
