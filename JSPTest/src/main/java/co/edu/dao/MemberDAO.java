package co.edu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import co.edu.vo.MemberVO;

public class MemberDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public void connect() {
		try {
			InitialContext ic = new InitialContext();
			DataSource ds = (DataSource)ic.lookup("java:comp/env/jdbc/myoracle");
			conn = ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//connect()
	public void disconnect() {
		try {
			if(rs != null) 
				rs.close();	
			if(pstmt != null) 
				pstmt.close();	
			if(conn != null) 
				conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	//입력
	public void insertMemeber(MemberVO vo) {
		String sql ="insert into test_member(id, passwd, name, address) values(?,?,?,?)";
		connect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPasswd());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getAddr());
			
			int r = pstmt.executeUpdate();
			System.out.println(r+"건 입력");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	//리스트 출력
	public List<MemberVO> getList(){
		List<MemberVO> list = new ArrayList<>();
		connect();
		String sql = "select * from test_member order by 1";
		try {
			pstmt=conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setName(rs.getString("name"));
				vo.setPasswd(rs.getString("passwd"));
				vo.setAddr(rs.getString("address"));
				
				list.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}
	
	//단건조회 (id)
	public MemberVO searchMember(String id) {
		String sql = "select * from test_member where id=?";
		connect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setId(id);
				vo.setAddr(rs.getString("address"));
				vo.setName(rs.getString("name"));
				vo.setPasswd(rs.getString("passwd"));
				
				return vo;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
	}
	
	//수정
	public void updateMember(MemberVO vo) {
		String sql = "UPDATE test_member "
				+ "SET name=?, passwd=? ,address=? "
				+ "WHERE id=?";
		connect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPasswd());
			pstmt.setString(3, vo.getAddr());
			pstmt.setString(4, vo.getId());
			int r = pstmt.executeUpdate();
			System.out.println(r+"건 변경");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	//삭제
	public boolean deleteMember(String id) {
		String sql="DELETE from test_member WHERE id=?";
		int r=0;
		connect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			r = pstmt.executeUpdate();
			System.out.println(r+"건 삭제");
			if(r>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return false;
	}
	// 로그인체크
		public MemberVO loginCheck(String id, String pass) {
			String sql = "select * from test_member where id=? and passwd=?";
			connect();
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, id);
				pstmt.setString(2, pass);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					MemberVO vo = new MemberVO();
					vo.setId(rs.getString("id"));
					vo.setPasswd(rs.getString("passwd"));
					vo.setName(rs.getString("name"));
					return vo;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				disconnect();
			}
			return null;
		}

}
