package com.yedam.java.example2;
//DB분리시킨 상황. 필요에 따라 저장소 접근할 것
//->저장할 DB데이터를 매개변수로 받아옴
public interface Program {	
	//메뉴 출력
	public void menuPrint();
	//정보 입력
	public void inputInfo(Access access);
	//입력된 전체정보를 출력
	public void printAllInfo(Access access);
	//특정 조건의 정보를 출력
	public void printInfo(Access access);
	//분석
	public void printRepot(Access access);
}
