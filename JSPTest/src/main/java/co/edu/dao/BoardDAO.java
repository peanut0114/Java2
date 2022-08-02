package co.edu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import co.edu.vo.BoardVO;
import co.edu.vo.Criteria;

public class BoardDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	public void connect() {
		try {
			InitialContext ic = new InitialContext();
			DataSource ds = (DataSource) ic.lookup("java:comp/env/jdbc/myoracle");
			conn = ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// connect()
	public void disconnect() {
		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 등록
	public void insertBoard(BoardVO vo) {
		String sql = "insert into test_board values(board_seq.nextval,?,?,?,sysdate,0)";
		connect();
		try {
			pstmt = conn.prepareStatement(sql); // pstmt를 통해 데이터를 주고받음
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getWriter());
			pstmt.setString(3, vo.getContent());

			int r = pstmt.executeUpdate();
			System.out.println(r + "건 입력");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

	}

	// 목록
	public List<BoardVO> boardList() {
		List<BoardVO> list = new ArrayList();
		try {
			connect();
			String sql = "select * from test_board order by 1";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setSeq(rs.getInt("seq"));
				vo.setTitle(rs.getString("title"));
				vo.setWriter(rs.getString("writer"));
				vo.setContent(rs.getString("content"));
				vo.setDate(rs.getDate("write_date"));
				vo.setVisitCnt(rs.getInt("visit_cnt"));

				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	// 단건조회
	public BoardVO searchBoard(int seq) {
		String sql = "select * from test_board where seq=?";
		connect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, seq);

			rs = pstmt.executeQuery();
			// key값이기 때문에 결과는 0 또는 1개
			if (rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setSeq(rs.getInt("seq"));
				vo.setTitle(rs.getString("title"));
				vo.setWriter(rs.getString("writer"));
				vo.setContent(rs.getString("content"));
				vo.setDate(rs.getDate("write_date"));
				vo.setVisitCnt(rs.getInt("visit_cnt"));

				setCnt(seq); // 출력 후 조회수 증가
				return vo;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
	}

	// 조회수증가
	public void setCnt(int seq) {
		String sql = "update test_board set visit_cnt=visit_cnt+1 where seq=?";
		connect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, seq);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 글내용 수정
	public void updateBoard(BoardVO vo) {
		String sql = "update test_board set title=?, content=? where seq=?";
		connect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setInt(3, vo.getSeq());

			int r = pstmt.executeUpdate(); // 쿼리 실행
			System.out.println(r + "건 변경");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

	}

	// 삭제
	public void deleteBoard(int seq) {
		String sql = "delete from test_board where seq=?";
		connect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, seq);

			int r = pstmt.executeUpdate(); // 쿼리 실행
			System.out.println(r + "건 삭제");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	// 페이징 처리
	public List<BoardVO> getListPaging(Criteria cri){
		List<BoardVO> listPage = new ArrayList();
		String sql = " select * "
					+ "from( select rownum rn, seq, title, content, writer, write_date, visit_cnt "
					+ "      from( select * "
					+ "            from test_board "
					+ "            order by seq ) "
					+ "      where rownum<=?) "
					+ "where rn>?";
		connect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cri.getAmount()*cri.getPageNum());//10*1
			pstmt.setInt(2, cri.getAmount()*(cri.getPageNum()-1));//10*(1-1)
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardVO board = new BoardVO();
				board.setSeq(rs.getInt("seq"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setWriter(rs.getString("writer"));
				board.setDate(rs.getDate("write_date"));
				board.setVisitCnt(rs.getInt("visit_cnt"));
				
				listPage.add(board);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return listPage;
	}

}
