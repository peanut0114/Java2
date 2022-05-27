package com.yedam.java.example2;
//저장소는 하나  -> 싱글톤으로 만들어야함 (외부에서 인스턴스 못 만들게 private)
public class StudentRepo implements Access {
	
///////싱글톤////// 
	//내부에서 인스턴스 만듬(new) : 반드시 static (클래스이름으로 접근가능하게)
	private static StudentRepo instance = new StudentRepo(); 
	private StudentRepo(){	
		init();
	}
	public static StudentRepo getInstance() {	//외부에서 호출시 반환시켜줌 (클래스명으로 접근)
		return instance;
	}
/////////////////
	
	//실제 사용 필드 및 메소드
	private Student[] dataList;
	private int listIndex;
	
	private void init() {				//필드 초기화하는 메소드
		dataList = new Student[100];
		listIndex = -1;
	}
	
	
	@Override
	public void insert(Student student) {
		dataList[++listIndex]=student;
	}

	@Override
	public void update(Student student) {
		for(int i=0; i<=listIndex; i++) {
			if(dataList[i].getId()==student.getId()) {
				dataList[i] = student;	//모든 정보 덮어 씀
				//dataList[i].setScore(student.getScore()); //일부만 수정할때
			}
		}
	}

	@Override
	public void delete(int studentId) {
		for (int i=0 ; i<=listIndex; i++) {
			if(dataList[i].getId()==studentId) {
				dataList[i]=null;
			}
		}
		cleanDataList();	//필드값 복사해놓고 초기화후 다시 순차대로 입력
	}
	
	private void cleanDataList() {	//빈 공간 채워서 다시 정리
		//기존 데이터 - > 임시변수
		Student[] tempList = dataList;
		int tempIndex = listIndex;
		//기존 필드 초기화
		init();
		//임시변수에서 데이터만 기존 필드로 복사
		for(int i=0 ; i<=tempIndex ; i++) {
			if(tempList[i] != null) {
				dataList[++listIndex]=tempList[i];
			}
		}
	}
	
	@Override
	public Student[] selectAll() {
		Student[] list = new Student[listIndex+1]; //실제 크키로 만든 임시변수
		for(int i=0;i<=listIndex;i++) {
			list[i] = dataList[i];
		}
		return list; 
	}

	@Override
	public Student selectOne(int studentId) {	//빈 값이 있기 때문에 향상된for문 사용X
		Student selected = null;
		for(int i=0 ; i<=listIndex ; i++) {
			if(dataList[i].getId()==studentId) {
				selected = dataList[i];
			}
		}
		return selected;
	}

}
