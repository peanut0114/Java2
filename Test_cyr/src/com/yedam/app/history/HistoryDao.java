package com.yedam.app.history;
import java.sql.SQLException;

//DB Product_history table 컨트롤
//수정 - 입고량/출고량
//조회 - 재고 (서브쿼리사용)
import com.yedam.app.common.Dao;

public class HistoryDao extends Dao {

	//싱글톤
	private HistoryDao() {}
	public static HistoryDao historyDao = null;
	public static HistoryDao getInstance() {
		if(historyDao==null) {
			historyDao = new HistoryDao();
		}
		return historyDao;
	}
	
	//CRUD
	//insert
	public void insert(History history) {
		try {
			connect();
			String sql= "INSERT INTO product_history VALUES(?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, history.getProductId());
			pstmt.setInt(2, history.getProductCategory());
			pstmt.setInt(3, history.getProductAmount());
			
			int result = pstmt.executeUpdate();
			if(result>0) {
				System.out.println("정상적으로 입력되었습니다.");
			}else {
				System.out.println("정상적으로 입력되지 않았습니다.");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
	}
	
	//update - 재고
	public void update(History history) {
		try {
			connect();
			String sql = "UPDATE product_history SET product_amount = ? WHERE product_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, history.getProductAmount());
			pstmt.setInt(2, history.getProductId());
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
	}
	
	//delete
	public void delete(int productId) {
		try {
			connect();
			String sql = "DELETE FROM product_history WHERE product_id="+productId;
			stmt = conn.createStatement();
			int result = stmt.executeUpdate(sql);
			if(result>0) {
				System.out.println(result+"건을 삭제했습니다.");
			}else {
				System.out.println("정상적으로 삭제되지 않았습니다.");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
	}
	
	//단건조회
	//-1. 입고량 (카테고리가 1인 항목 합)
	public int inAmount(int productId) {
		int result=0;
		try {
			connect();
			String sql= "SELECT SUM(product_amount) FROM product_history"
					+ "WHERE product_category = 1"
					+ "AND product_id = "+productId
					+ "GROUP BY product_id";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return result;
	}
	//-2. 출고량
	//전체조회
	
}
