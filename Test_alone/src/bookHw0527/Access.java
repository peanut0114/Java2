package bookHw0527;

public interface Access {
	//등록
	public void insert(Book book);
	
	//수정
	public void update(Book book);
	
	//삭제
	public void delete(Book book);
	//단건조회
	public Book printOne(int isbn);
	//전체조회
	public Book[] printAll();
	
}
