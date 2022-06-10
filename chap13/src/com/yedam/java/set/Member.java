package com.yedam.java.set;
/*
 * 내가 만든 클래스에 대해서는 hashCode와 equls를 별도로 재정의 해주지 않으면
 * set을 사용할 때 동일 클래스라고 인지하지 못함
 */
public class Member {
	public String name;
	public int age;
	
	public Member(String name, int age) {	//이름과 나이를 가짐
		this.name = name;
		this.age = age;
	}
	
	@Override
	public int hashCode() {
		return name.hashCode()+age;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Member) {
			Member m = (Member)obj;
			return name.equals(m.name) && (age==m.age);	//둘 다 참일때만 참이 나오게
		}
		return false;
	}
}
