package com.yedam.app.deal;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.app.common.DAO;
//RecivingGoods : deal_date, product_id, product_amount
public class ReceivingGoodsDAO extends DAO {

	//싱글톤
	private static ReceivingGoodsDAO dao = null;
	private ReceivingGoodsDAO() {}
	public static ReceivingGoodsDAO getInstance() {
		if(dao==null) {
			dao = new ReceivingGoodsDAO();
		}
		return dao;
	}
	
	//기능 : 등록/단건조회/전체조회	
	//기본키가 없어 수정,삭제 불가능 -> 기능 넣고싶으면 기본키 생성할것
	
	//등록
	public void insert(DealInfo info) {
		try {
			connect();	//날짜는 sysdate 디폴트로 들어가므로 두개의 값만 입력
			String sql = "INSERT INTO receiving_goods (product_id, product_amount) "
						+ "VALUES (?, ?) ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, info.getProductId());
			pstmt.setInt(2, info.getProductAmount());
			
			int result = pstmt.executeUpdate();
			if(result>0) {
				System.out.println(result+"건 등록되었습니다.");
			}else { 
				System.out.println("정상적으로 등록되지 않았습니다.");
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
	}
	
	//단건조회 - 입고내역 존재유무
	public boolean selectInfo(int productId) {
		boolean isSelected = false;	//필요할때만 true되도록 false로 초기화
		try {
			connect();
			String sql = "SELECT COUNT(*) AS count "
						+"FROM receiving_goods "
						+ "WHERE product_id="+productId;
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				if(rs.getInt("count")>0) {	//결과가 없어도 0은 반드시 반환됨
					isSelected = true;
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return isSelected;
	}
	
	//단건조회 - 입고수량 확인
	public int selectAmount(int productId) {
		int amount = 0;
		try {
			connect();
			String sql = "SELECT NVL(SUM(product_amount),0) as sum "
						+ "FROM receiving_goods "
						+ "WHERE product_id = "+productId;
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				amount = rs.getInt("sum");	//별칭으로 가져오기 가능
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return amount;
	}
	
	//전체조회 - 현재까지 입고된 내역
	public List<DealInfo> selectAll(){
		List<DealInfo> list = new ArrayList<>();
		
		try {
			connect();
			String sql = "SELECT r.deal_date, r.product_id"
							+ ", p.product_name, r.product_amount "
					+ "FROM products p JOIN receiving_goods r "
					+ "ON p.product_id = r.product_id "
					+ "ORDER BY r.deal_date";
			pstmt = conn.prepareStatement(sql);
			rs =  pstmt.executeQuery();
			while(rs.next()) {
				DealInfo info = new DealInfo();
				info.setDealDate(rs.getDate("deal_date"));
				info.setProductId(rs.getInt("product_id"));
				info.setProductName(rs.getString("product_name"));
				info.setProductAmount(rs.getInt("product_amount"));
				
				list.add(info);
			}
		}catch(SQLException e) {
			e.printStackTrace(); 
		}finally {
			disconnect();
		}
		return list;
	}
	
	//전체조회 - 해당 날짜에 입고된 내역
	public List<DealInfo> selectAll(Date dealDate){
		List<DealInfo> list = new ArrayList<>();
		
		try {
			connect();
			String sql = "SELECT r.deal_date, r.product_id"
							+ ", p.product_name, r.product_amount "
					+ "FROM products p JOIN receiving_goods r "
					+ "ON p.product_id = r.product_id "
					+ "WHERE deal_date = ? "
					+ "ORDER BY r.deal_date";
			pstmt = conn.prepareStatement(sql);
			pstmt.setDate(1, dealDate);
			rs =  pstmt.executeQuery();
			while(rs.next()) {
				DealInfo info = new DealInfo();
				info.setDealDate(rs.getDate("deal_date"));
				info.setProductId(rs.getInt("product_id"));
				info.setProductName(rs.getString("product_name"));
				info.setProductAmount(rs.getInt("product_amount"));
				
				list.add(info);
			}
		}catch(SQLException e) {
			e.printStackTrace(); 
		}finally {
			disconnect();
		}
		return list;
	}
	
	//전체조회 - 해당 제품의 입고된 내역
	public List<DealInfo> selectAll(int productId){
		List<DealInfo> list = new ArrayList<>();
		
		try {
			connect();
			String sql = "SELECT r.deal_date, r.product_id"
							+ ", p.product_name, r.product_amount "
					+ "FROM products p JOIN receiving_goods r "
					+ "ON p.product_id = r.product_id "
					+ "WHERE product_id = ? "
					+ "ORDER BY r.deal_date";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, productId);
			rs =  pstmt.executeQuery();
			while(rs.next()) {
				DealInfo info = new DealInfo();
				info.setDealDate(rs.getDate("deal_date"));
				info.setProductId(rs.getInt("product_id"));
				info.setProductName(rs.getString("product_name"));
				info.setProductAmount(rs.getInt("product_amount"));
				
				list.add(info);
			}
		}catch(SQLException e) {
			e.printStackTrace(); 
		}finally {
			disconnect();
		}
		return list;
	}
	
	
	
	
}

