package co.edu.service;

import java.util.List;

import co.edu.dao.MemberDAO;
import co.edu.vo.MemberVO;

public class MemberService {

	// 싱글톤
	private static MemberService instance = new MemberService();

	private MemberService() {
	}

	public static MemberService getInstance() {
		return instance;
	}

	MemberDAO dao = new MemberDAO();

	// 회원가입
	public void addMember(MemberVO vo) {
		dao.insertMemeber(vo);
	}

	// 회원목록
	public List<MemberVO> memberList() {
		return dao.getList();
	}

	// 회원조회
	public MemberVO getMember(String id) {
		return dao.searchMember(id);
	}

	// 회원정보수정
	public void modifyMember(MemberVO vo) {
		dao.updateMember(vo);
	}

	// 회원정보 삭제
	public boolean removeMember(String id) {
		return dao.deleteMember(id);
	}
}
