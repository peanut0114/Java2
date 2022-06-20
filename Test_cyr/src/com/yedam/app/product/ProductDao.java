package com.yedam.app.product;
import java.sql.SQLException;
import java.util.List;

import com.yedam.app.common.Dao;
/*
 * ProductDAO : DB Product table 컨트롤 (싱글톤 + CRUD 작업)
				수정 - 가격 / 이름
 */
public class ProductDao extends Dao {
	//싱글톤
	private ProductDao() {}
	public static ProductDao productDao=null;
	public static ProductDao getInstance() {
		if(productDao==null) {
			productDao = new ProductDao();
		}
		return productDao;
	}
	
	//CRUD 작업
	public void insert(Product product) {
		try {
			connect();
			String sql = "INSERT INTO product VALUES(product_seq.nextval,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product.getProductName());
			pstmt.setInt(2, product.getProductPrice());
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
	
	public void update(Product product) {
		try {
			connect();
			String sql = "UPDATE TABLE product SET product_price=? WHERE product_name=? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(2, product.getProductName());
			pstmt.setInt(1, product.getProductPrice());
			
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
	
	public void delete(String productName) {
		try {
			connect();
			String sql = "DELETE FROM product WHERE product_id='"+productName+"'";
			stmt = conn.createStatement();
			int result = stmt.executeUpdate(sql);
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
	
	public Product slectOne(String productName) {
		Product pro = null;
		try {
			connect();
			String sql = "SELECT * FROM product WHERE product_name='"+productName+"'";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				pro=new Product();
				pro.setProductId(rs.getInt("product_id"));
				pro.setProductName(rs.getString("product_name"));
				pro.setProductPrice(rs.getInt("product_price"));
			}
		}catch(SQLException e ) {
			e.printStackTrace();
		}finally{
			disconnect();
		}
		return pro;
	}
	
	public List<Product> selectAll(){
		List<Product> list = null;
		
		try {
			connect();
			String sql = "SELECT * FROM product";
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
