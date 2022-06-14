package com.yedam.java.map;

import com.yedam.java.set.Member;

public class Student {

	public String name;
	public int sno;

	public Student(int sno, String name) {
		this.sno = sno;
		this.name = name;
	}

//	@Override	//해시코드 : 물리상 동일한 메모리상에 존재하는가
//	public int hashCode() {	
//		return name.hashCode()+sno;	//String은 내부값 같으면 같은 해시코드 가져옴 + 학번
//	}
//
//	@Override	//이퀄즈 : 내부값의 모든 값이 같은가
//	public boolean equals(Object obj) {
//		if(obj instanceof Student) {	//매개변수 obj가 Student타입인가 (이름만 다르고 내부구성 같을 수 있음)
//			Student s = (Student)obj;	//강제 타입변환후 각각의 필드값 확인
//			return name.equals(s.name) && (sno==s.sno);	//둘 다 참일때만 참이 나오게
//		}
//		return false;
//	}

}
