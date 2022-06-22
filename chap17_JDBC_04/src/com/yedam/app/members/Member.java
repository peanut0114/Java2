package com.yedam.app.members;
//member 테이블의 vo 클래스
public class Member {

	private String memberId;
	private String memberPassword;
	private int memberRole;	//권한 : memberRole 0 = 관리자, 1 = 일반회원
	
	@Override
	public String toString() {
		String info;
		if(memberRole == 0) {
			info = "관리자 계정 : " + memberId ;
		}else {
			info = "일반 계정 : " + memberId ;
		}
		return info;
	}
	
	//getter, setter
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPassword() {
		return memberPassword;
	}
	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}
	public int getMemberRole() {
		return memberRole;
	}
	public void setMemberRole(int memberRole) {
		this.memberRole = memberRole;
	}
	
	
	
}
