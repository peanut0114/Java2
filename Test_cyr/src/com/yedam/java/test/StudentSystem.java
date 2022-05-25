package com.yedam.java.test;

public class StudentSystem {

	private Student[] list;
	static int index = -1;

	// 2-1. 메뉴 구성
	public void menuSet() {
		System.out.println("1.학생수 입력 2.학생정보 등록 3.학생정보 전체조회 4.학생정보 분석 5.종료");
		System.out.print("선택 > ");
	}

	// 2-2. 등록 가능한 학생정보 수 지정
	public void listSize(int size) {
		list = new Student[size];
	}

	// 2-3. 학생정보 입력
	public void makeList(int num, String name, int score) {
		Student student = new Student(num, name, score);
		list[++index] = student;
	}

	// 등록 가능한 수를 넘어섰는지 체크
	public boolean check() {
		if (index + 1 < list.length) {
			return true;
		} else
			return false;
	}

	// 3. 전체조회
	public void printList() {
		for (int i = 0; i <= index; i++) {
			list[i].printInfo();
		}
	}

	// 4-1-1. 최고점 학번, 점수 출력
	public Student maxScore() {
		Student temp = new Student();
		temp = list[0];
		for (int i = 1; i <= index; i++) {
			if (temp.getScore() < list[i].getScore()) {
				temp = list[i];
			}
		}
		return temp;
	}

	// 4-1-2. 최저점 학번, 점수 출력
	public Student minScore() {
		Student temp = new Student();
		temp = list[0];
		for (int i = 1; i <= index; i++) {
			if (temp.getScore() > list[i].getScore()) {
				temp = list[i];
			}
		}
		return temp;
	}

	// 4-2. 최고점 최저점을 제외한 평균점수 (소수점 이하 두자리)
	public double avgScore() {
		double sum = 0;
		for (int i = 0; i <= index; i++) {
			sum += list[i].getScore();
		}
		sum -= (maxScore().getScore() + minScore().getScore());
		if (sum<=0) {	//저장된 정보가 적을 경우 0으로 반환
			return 0;
		}else {
			return sum / (double) (index - 1);
		}
	}

	// 4. 분석 출력
	public void printResult() {
		if(index<0) {	//저장된 값이 없는 경우
			System.out.println("학생정보를 등록하세요.");
		}else {
		System.out.printf("최고점수 : %d점, 학번 : %d\n", maxScore().getScore(), maxScore().getNum());
		System.out.printf("최저점수 : %d점, 학번 : %d\n", minScore().getScore(), minScore().getNum());
		System.out.printf("최고점, 최저점을 제외한 평균 점수는 %.2f점 입니다.\n\n", avgScore());
		}
	}

}
