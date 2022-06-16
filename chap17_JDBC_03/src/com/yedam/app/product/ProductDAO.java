package com.yedam.app.product;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.app.common.DAO;
//DB에 대한건 DAO에서 컨트롤
public class ProductDAO extends DAO {
	//싱글톤
	public static ProductDAO productDAO = null;
	private ProductDAO() {}
	public static ProductDAO getInstance() {
		if(productDAO ==null) {
			productDAO = new ProductDAO();
		}
		return productDAO;
	}
	
	//CRUD
	//등록
	public void insert(Product product) {
		try {
			connect();
			String sql = "INSERT INTO product VALUES (product_seq.nextval,?,?)";
													//제품번호는 시퀀스를 이용해서 입력
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,product.getProductName());
			pstmt.setInt(2, product.getProductPrice());
			
			int result = pstmt.executeUpdate();
			
			if(result>0) {
				System.out.println("♬정상적으로 등록되었습니다.♬");
			}else {
				System.out.println("※정상적으로 등록되지 않았습니다.※");
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
	}
	
	//수정 - 가격
	public void update(Product product) {
		try {
			connect();
			String sql = "UPDATE product SET product_price=? WHERE product_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, product.getProductPrice());
			pstmt.setInt(2, product.getProductId());
			
			int result = pstmt.executeUpdate();
			
			if(result>0) {
				System.out.println("♬정상적으로 수정되었습니다.♬");
			}else {
				System.out.println("※정상적으로 수정되지 않았습니다.※");
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
	}
	
	//삭제
	public void delete(Product product) {
		try {
			connect();
			String sql = "DELETE FROM product WHERE product_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, product.getProductId());
			
			int result = pstmt.executeUpdate();
			
			if(result>0) {
				System.out.println("♠정상적으로 삭제되었습니다.♠");
			}else {
				System.out.println("※정상적으로 삭제되지 않았습니다.※");
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
	}
	
	//단건조회 - 1. 제품번호
	public Product selectOne(int productId){
		Product pro = null;
		try {
			connect();
			String sql = "SELECT * FROM product WHERE product_id="+productId;
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				pro = new Product();
				pro.setProductId(rs.getInt("procduct_id"));
				pro.setProductName(rs.getString("product_name"));
				pro.setProductPrice(rs.getInt("product_price"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return pro;
	}
	//단건조회 - 2. 제품이름
	public Product selectOne(String productName){
		Product pro = null;
		try {
			connect();
			String sql = "SELECT * FROM product WHERE product_name="+productName;
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				pro = new Product();
				pro.setProductId(rs.getInt("procduct_id"));
				pro.setProductName(rs.getString("product_name"));
				pro.setProductPrice(rs.getInt("product_price"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return pro;
	}
	//전체조회
	public List<Product> selectAll(){
		List<Product> list = new ArrayList<>();
		try {
			connect();
			String sql = "SELECT * FROM product ORDER BY 1";
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Product pro = new Product();
				pro.setProductId(rs.getInt("product_id"));
				pro.setProductName(rs.getString("product_name"));
				pro.setProductPrice(rs.getInt("product_price"));
				
				list.add(pro);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return list;
	}
	
}
