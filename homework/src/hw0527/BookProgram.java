package hw0527;
/*
 * 무엇을 호출하면 되는지
 * 메뉴출력 정보입력 분석 등등 
 */
public interface BookProgram {
	//메뉴 선택
	public void menuPrint();
	//1. 책 정보 입력(isbn 번호 할당)
	public void insertInfo(Access repo);
	//2. 전체조회
	public void printAllInfo(Access repo);
	//3. 검색
	public void printInfo(Access repo);
	//4. 분석(최대,최소,제외한 평균)
	public void printReport(Access repo);
	//5. 수정
	public void updateInfo(Access repo);
	//6. 삭제
	public void deletInfo(Access repo);
}
