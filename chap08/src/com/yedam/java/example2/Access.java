package com.yedam.java.example2;
//저장소에 대해 사용방법을 정의
//db 관리
public interface Access {
	//등록
	public void insert(Student student);
	//수정
	public void update(Student student);
	//삭제
	public void delete(int studentId);
	//전체조회
	public Student[] selectAll();
	//단건조회
	public Student selectOne(int studentId);
}
