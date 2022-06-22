package com.yedam.app.members;
import java.sql.SQLException;

import com.yedam.app.common.DAO;

public class MemberDAO extends DAO {
	//싱글톤
	private static MemberDAO dao = null;
	private MemberDAO() {}
	public static MemberDAO getInstance() {
		if(dao == null) {
			dao = new MemberDAO();
		}
		return dao;
	}
	
	//DRUD - 지금은 내부적 회원가입이나 정보수정X 권한만 가져올거임
	public Member selectOne(Member member) {	//member에 아이디와 비번을 입력받아 넘어옴
		Member loginInfo = null;
		try {
			connect();
			//select 할 때 id만 가지고 함 (로그인이 안되는 이유가 id 때문인지 pw 때문인지 구분하기 위해
			String sql = "SELECT * FROM members WHERE member_id='"+member.getMemberId()+"'";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {	//id 존재
				//가져온 셀렉문의 pw와 입력받은(매개변수) pw 값이 같은지 확인
				if(rs.getString("member_password").equals(member.getMemberPassword())) {
					//비밀번호 일치 -> 로그인 성공
					loginInfo = new Member();	//일치시에만 정보입력 
					loginInfo.setMemberId(rs.getString("member_id"));
					loginInfo.setMemberPassword(rs.getString("member_password"));
					loginInfo.setMemberRole(rs.getInt("member_role"));
					
				}else {
					System.out.println("비밀번호가 일치하지 않습니다.");
				}
			}else {
				System.out.println("아이디가 존재하지 않습니다.");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return loginInfo;
	}

}
