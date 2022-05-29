package hw0527;
/*
 * 저장소 등록 수정 삭제
 */
public interface Repo {

	void insert(Book book);
	public void update(Book book);
	public void delete(Book book);
	public Book selectOne(int isbn);
	public Book[] selectAll();
}
