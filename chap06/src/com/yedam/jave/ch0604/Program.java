package com.yedam.jave.ch0604;
/*
 * 점수 리스트 분석 프로그램
 * 201p Ex6 클래스로 만들기
 *
 * 1. 학생수 입력 (필드 초기화 : 값 반환x : void)
 * 2. 점수 입력 
 * 3. 점수리스트 출력
 * 4. 분석 - 최고점수, 평균점수 출력
 */ 
 
public class Program {
	//필드
	int[] scores;
	int index ;
//	private int i;
	
	//생성자
	Program(){
		index = -1;
	}
	//메소드
	//1. 학생 수 입력 (배열초기화)
	void setNum(int student) {
		scores = new int [student];
	}
	
	//2. 점수 입력
	void setScore(int score) {
		scores[++index]=score;
	}
	
	//3. 점수 리스트 출력 (값 반환x : void)
	void printScores() {
		for(int i=0; i<scores.length ; i++) {
			System.out.printf("scores[%d]>%d\n",i,scores[i]);
		}
	}
	
	//4-1. 최고점수
	int getMax() {		
		int max=scores[0];
		for(int i=1;i<scores.length;i++) {
			if(max<scores[i]) {
				max=scores[i];
			}
		}
		return max;
	}
	
	//4-2. 평균점수
	double getAvg() {
		int sum = 0;
		for(int i=0 ; i<scores.length ; i++) {
			sum += scores[i];
		}
		return (double)sum/scores.length;
	}
	
	//4. 결과출력
	void printResult() {
		System.out.println("최고점수 : "+getMax());
		System.out.println("평균점수 : "+getAvg());
	}
}
