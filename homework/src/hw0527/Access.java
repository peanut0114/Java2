package hw0527;
/*
 * 저장소 등록 수정 삭제
 */
public interface Access {
	//등록
	void insert(Book book);
	//수정
	public void update(Book book);
	//삭제
	public void delete(Book book);
	//단전조회
	public Book selectOne(int isbn);
	//전체조회
	public Book[] selectAll();
}
