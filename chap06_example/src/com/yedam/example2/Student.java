package com.yedam.example2;
/*
 * 정적필드
 * 학번, 계좌번호
 */
public class Student {
	//필드
	private static int serialNum = 1000;	//1000번부터 번호 발행
	
	private int studentId;	//학번
	private String name;
	
	
	//생성자
	public Student(String name) {
		this.name = name;
		serialNum++;
		this.studentId = serialNum;		
	}
	
	//메소드
	public static int getSerialNum() {
		return serialNum;
	}
	
	public int getStudentId() {
		return studentId;
	}
	
	public String name() {
		return name;
	}

}
