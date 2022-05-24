package com.yedam.example2;

public class StudentSystem {

	public static void main(String[] args) {
		
		Student hong = new Student("홍이지");
		System.out.println(Student.getSerialNum());
		System.out.printf("%s의 학번 : %d\n",hong.name(),hong.getStudentId());
		
		Student lee = new Student("이수호");
		System.out.println(Student.getSerialNum());
		System.out.printf("%s의 학번 : %d\n",lee.name(),lee.getStudentId());

	}
}
