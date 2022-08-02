package co.edu.service;

import java.util.List;

import co.edu.dao.BoardDAO;
import co.edu.vo.BoardVO;
import co.edu.vo.Criteria;

public class BoardService {

	// 싱글톤
	private static BoardService instance = new BoardService();

	private BoardService() {
	}

	public static BoardService getInstance() {
		return instance;
	}

	BoardDAO dao = new BoardDAO();

	
	// 게시글목록
	public List<BoardVO> boardList() {
		return dao.boardList();
	}
	// 게시글등록
	public void addBoard(BoardVO vo) {
		dao.insertBoard(vo);
	}

	// 회원조회
	public BoardVO getMember(int seq) {
		return dao.searchBoard(seq);
	}

	// 게시글수정
	public void modifyMember(BoardVO vo) {
		dao.updateBoard(vo);
	}

	// 게시글 삭제
	public void removeMember(int seq) {
		dao.deleteBoard(seq);
	}
	
	// 페이징
	public List<BoardVO> getListPaging(Criteria cri){
		return dao.getListPaging(cri);//10건씩
	}
	
}
