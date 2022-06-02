package com.yedam.java.ch1101;
/*
 * Object를 상속하는 새로운 클래스 Member 
 */
public class Member {
	//필드
	public String id;	//2개의 다른 인스턴스에서 같은 id들어있으면 논리적으로 동등하다고 봄
	//생성자
	public Member(String id) {
		this.id = id;
	}
	

	@Override
	public boolean equals(Object obj) {
		//논리적으로 동등한지
		
		//1.동일한 타입인지
		if(obj instanceof Member) {
			//2.내부 필드 값이 같은지
			Member member = (Member) obj;
			if(id.equals(member.id)) {	//String 값 비교는 equals써야함 (==불가)
				return true;
			}
		}
		return false; 
	}
	
}
