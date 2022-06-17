package com.yedam.app.history;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.yedam.app.common.DAO;
/*
 * DAO 상속받는 클래스
 * 부모에서 정보있기때문에 싱글톤만 각각의 CRUD만 만들면 됨
 */
public class HistoryDAO extends DAO {
	
	//싱글톤
	private static HistoryDAO historyDAO = null;
	private HistoryDAO() {}
	public static HistoryDAO getInstance() {
		if(historyDAO==null) {
			historyDAO = new HistoryDAO();
		}
		return historyDAO;
	}
	
	//CRUD
	//등록
	public void insert(History history) {
		try {
			connect();
			String sql 
			= "INSERT INTO product_history VALUES(?,?,?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, history.getProductId());
			pstmt.setInt(2, history.getProductCategory());
			pstmt.setInt(3, history.getProductAmount());
			
			int result = pstmt.executeUpdate();
			
			if(result>0) {
				System.out.println("정상적으로 등록되었습니다.");
			}else {
				System.out.println("정상적으로 등록되지 않았습니다.");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
	}
	
	//수정 : 무엇을 수정하느냐로 나눠줌 -> 지금은 수량만
	public void update(History history) {
		try {
			connect();
			String sql 
			= "UPDATE product_history SET product_amount=? WHERE product_id=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, history.getProductAmount());
			pstmt.setInt(2, history.getProductId());
			
			int result = pstmt.executeUpdate();
			if(result>0) {
				System.out.println("정상적으로 수정되었습니다.");
			}else {
				System.out.println("정상적으로 수정되지 않았습니다.");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
	}
	
	//삭제
	public void delete(History history) {
		try {
			connect();
			String sql 
			= "DELETE FROM product_history WHERE product_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, history.getProductId());
			
			int result = pstmt.executeUpdate();
			if(result>0) {
				System.out.println("정상적으로 삭제되었습니다.");
			}else {
				System.out.println("정상적으로 삭제되지 않았습니다.");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
	}
	
	//단건조회 -> 기존과 좀 다른 형태 주의
	//조회 1. 각 상품에 대한 입고량  
	public int selectInAmount(int productId) {
		int result = 0;
		try {
			connect();
			String sql
			= "SELECT SUM(product_amount) sum "
			+ "FROM product_history "
			+ "WHERE product_id=?"
			+ "AND product_category =1"; //입고(1)일때만 가져옴
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,	productId);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				//세가지 방법 있음
				//result = rs.getInt("SELECT SUM(product_amount)");//그대로 가져오거나
				//result = rs.getInt("sum"); //별칭 이용
				result = rs.getInt(1);	//select문 순서 이용
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return result;
	}
	//조회 2. 각 상품에 대한 출고량
	public int selectOutAmount(int productId) {
		int result = 0;
		try {
			connect();
			String sql
			= "SELECT SUM(product_amount) sum "
			+ "FROM product_history "
			+ "WHERE product_id=?"
			+ "AND product_category =2"; //출고(2)일때만 가져옴
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,	productId);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				//세가지 방법 있음
				//result = rs.getInt("SELECT SUM(product_amount)");//그대로 가져오거나
				//result = rs.getInt("sum"); //별칭 이용
				result = rs.getInt(1);	//select문 순서 이용
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return result;
	}
	
	//전체조회 : 전체 상품의 각 재고 (쿼리가 복잡해 데이터 들고와서 자바에서 처리할거임
	public Map selectAllAmount() {
		Map<Integer, Integer> list = new HashMap<>();
		try {
			connect();
			//1. DB에서 각 제품에 따른 입고량과 출고량을 가져옴
			String sql = "SELECT product_id, product_category, SUM(product_amount) amount"
						+ " FROM product_history"
						+ " GROUP BY product_id, product_category"
						+ " ORDER BY 1";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			//2. 입고와 출고에 따른 각각의 목록 구분 
			//아이디가 뭔지만 알면 맵으로 가져오는게 빠름
			Map<Integer, Integer> inList = new HashMap<>();	
			Map<Integer, Integer> outList = new HashMap<>();
			
			while(rs.next()) {
				int category = rs.getInt("product_category"); //1=입고,2=출고
				if(category==1) {	//입고
					inList.put(rs.getInt("product_id"), rs.getInt("amount"));
				}else {				//출고
					outList.put(rs.getInt("product_id"), rs.getInt("amount"));
				}
			}
			
			//출고가 되었다는건 무조건 입고가 되었다는 뜻
			//3. 재고 구하기 (key를 이용해서 값 가져옴)
			Set<Integer> keySet = inList.keySet();
			for(int key : keySet) {
				int inAmount = inList.get(key);	 //입출고에서 가져오려는 값 가져옴
				Integer outAmount = outList.get(key);
				
				if(outAmount != null) {	//출고수량이 있을 때 재고=입고-출고
					list.put(key, inAmount-outAmount);
				}else{					//출고가 없으면 입고량이 재고량
					list.put(key, inAmount);
				}
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		
		return list;
	}
}
