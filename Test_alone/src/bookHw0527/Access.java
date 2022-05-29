package bookHw0527;

public interface Access {
	//등록
	public void insert(Book book);
	
	//조회
	public Book[] printAll();
	public Book printOne(Book book);
	
	//수정
	public void update(Book book);
	
	//삭제
	public void delete(Book book);
}
