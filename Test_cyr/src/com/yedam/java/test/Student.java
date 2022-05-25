package com.yedam.java.test;

public class Student {

	private int num; // 학번
	private String name; // 이름
	private int score; // 점수

	
	public Student(){
		
	}
	//1-2.값 초기화 생성자
	public Student(int num, String name, int score) { 
		this.num = num;
		this.name = name;
		this.score = score;
	}

	//1-3. 필드별 getter
	public int getNum() {
		return num;
	}
	public String getName() {
		return name;
	}
	public int getScore() {
		return score;
	}
		
	public void printInfo() {
		System.out.printf("%d 학번의 점수는 %d입니다.\n",num,score);
	}
}
