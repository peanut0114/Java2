package com.yedam.java.example2;

public class Student {
	//필드
	private int id;
	private String name;
	private int score;
	
	//생성자
	public Student() {}
	public Student(int id, String name, int score) {
		this.id = id;
		this.name = name;
		this.score = score;
	}
	//메서드
	public void showInfo() {
		System.out.printf("학번 : %d, 이름 : %s, 점수 : %d\n",id,name,score);
	}
	//메서드 (getter,setter)
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
}
