package hw0527_ver2;
/*
 * 저장소 등록 수정 삭제
 */
public interface Access {
	//등록
	void insert(Book book);
	//수정
	void update(Book book);
	//삭제
	void delete(Book book);
	//단전조회
	Book selectOne(int isbn);		//DB는 반환해주기만(출력x)
	//전체조회
	Book[] selectAll();
}
