package com.yedam.java.example2;

import java.util.Scanner;

public class StudentProgram implements Program {
	private Scanner sc = new Scanner(System.in);
	
	@Override
	public void menuPrint() {
		System.out.println("=======================================");
		System.out.println("1.정보입력 |2.전체조회 |3.검색 |4.분석 |5.종료");
		System.out.println("=======================================");
	}

	//1. 정보입력
	@Override
	public void inputInfo(Access access) {
		//사용자가 정보를 입력
		Student info = inputAll();
		//저장소에 등록
		access.insert(info);
	}

	private Student inputAll() {
		System.out.println("학번 > ");
		int id = Integer.parseInt(sc.nextLine());
		System.out.println("이름 > ");
		String name = sc.nextLine();
		System.out.println("점수 > ");
		int score = Integer.parseInt(sc.nextLine());
		
		return new Student(id, name, score);
	}
	
	//2. 전체 조회
	@Override
	public void printAllInfo(Access access) {
		//저장소에서 데이터를 가져옴
		Student[] list = access.selectAll();
		//데이터 전체 출력
		for(Student student : list) {
			student.showInfo();
		}
	}

	//3. 검색
	@Override
	public void printInfo(Access access) {
		//검색 조건 입력
		int id = inputId();
		//저장소에서 검색
		Student info = access.selectOne(id);
		//출력
		info.showInfo();
	}
	public int inputId() {
		System.out.print("검색 학번 > ");
		return Integer.parseInt(sc.nextLine());
	}

	//4. 분석
	@Override
	public void printRepot(Access access) {
		//최고점수
		System.out.println("최고 점수 > ");
		Student maxInfo = selectMaxScore(access);
		maxInfo.showInfo();
		
		//최저점수
		System.out.println("최저 점수 > ");
		Student minInfo = selectMinScore(access);
		minInfo.showInfo();
		//평균점수
		double avgResult = calAvg(access);
		System.out.printf("평균 점수 > %.2f\n",avgResult);
		
	}
	
	private Student selectMaxScore(Access access) {
		Student[] list = access.selectAll();
		
		Student maxInfo = list[0];
		for(int i=1; i<list.length ; i++) {
			if(maxInfo.getScore()<list[i].getScore()) {
				maxInfo=list[i];
			}
		}
		return maxInfo;
	}
	private Student selectMinScore(Access access) {
		Student[] list = access.selectAll();
		
		Student minInfo = list[0];
		for(int i=1; i<list.length ; i++) {
			if(minInfo.getScore()>list[i].getScore()) {
				minInfo=list[i];
			}
		}
		return minInfo;
	}

	private double calAvg(Access access) {
		Student[] list = access.selectAll();
		
		double sum = 0;
		for (int i=0 ; i<list.length ; i++) {
			sum += list[i].getScore();
		}
		return sum/list.length;
	}
}
