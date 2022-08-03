package co.edu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import co.edu.vo.CartVO;

public class CartDAO {
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
	
	// cart 전체 데이터
	public List<CartVO> cartList(){
		String sql="SELECT * from cart";
		List<CartVO> cartList = new ArrayList<>();
		connect();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				CartVO cart = new CartVO();
				cart.setNo(rs.getInt("no"));
				cart.setPrice(rs.getInt("price"));
				cart.setProductNm(rs.getString("product_nm"));
				cart.setQty(rs.getInt("qty"));
				cartList.add(cart);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return cartList;
	}

	public void updateCart(int no, int qty) {
		String sql="UPDATE cart SET qty =? WHERE no=?";
		connect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, qty);
			pstmt.setInt(2, no);

			int r = pstmt.executeUpdate(); // 쿼리 실행
			System.out.println(r + "건 변경");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
}
