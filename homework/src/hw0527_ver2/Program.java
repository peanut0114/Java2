package hw0527_ver2;
/*
 * 무엇을 호출하면 되는지
 * 메뉴출력 정보입력 분석 등등 
 */
public interface Program {
	//메뉴 선택
	public void menuPrint();
	//1. 책 정보 입력(isbn 번호 할당)
	public void inputInfo();
	//2. 전체조회
	public void printAllInfo();
	//3. 검색
	public void printInfo();
	//4. 분석(최대,최소,제외한 평균)
	public void printReport();
	/*
	//5. 수정
	public void updateInfo();
	//6. 삭제
	public void deletInfo();
	*/
}
