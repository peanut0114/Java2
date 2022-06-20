package com.yedam.app.product;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.app.common.DAO;

public class ProductDAO extends DAO{

	private ProductDAO() {}
	public static ProductDAO productDAO =null;
	public static ProductDAO getInstance() {
		if(productDAO !=null) {
			productDAO = new ProductDAO();
		}
		return productDAO;
	}
	//CRUD - 기본 : 등록/수정/삭제/단건조회/전체조회
	//등록 : 매개변수 vo객체
	public void insert(Product product) {	
		try {
			connect();	//처음 등록시 재고가 default 0
			String sql = "INSERT INTO products(product_id, product_name, product_price) "
						+ "VALUES(product_seq.nextval, ?, ?)";	//줄바꿈시 공백주의
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product.getProductName());
			pstmt.setInt(2, product.getProductPrice());
			
			int result = pstmt.executeUpdate();
			if(result>0) {
				System.out.println(result+"건 등록되었습니다.");
			}else {
				System.out.println("※정상적으로 등록되지 않았습니다.※");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally{
			disconnect();
		}
	}
	
	//수정 - 재고
	public void update(Product product) {	
		try {
			connect();
			//preparedStatment 아닌 Statement 이용하려면 ?없이 sql문에 바로 DB에 입력
			String sql = "UPDATE products "
						+"SET product_stock ="+product.getProductStock()
						+"WHERE product_id ="+product.getProductId();
			stmt = conn.createStatement();
			int result = stmt.executeUpdate(sql);
			if(result>0) {
				System.out.println(result+"건 수정되었습니다.");
			}else {
				System.out.println("※정상적으로 수정되지 않았습니다.※");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally{
			disconnect();
		}
	}
	
	//삭제: 테이블의 기본키를 이용해서 삭제하는게 좋다 (여러건 삭제되지 않도록)
	public void delete(int productId) {	
		try {
			connect();
			String sql = "DELET FROM products WHERE product_id=" + productId;
			stmt = conn.createStatement();
			int result = stmt.executeUpdate(sql);
			if(result>0) {
				System.out.println(result+"건 삭제되었습니다.");
			}else {
				System.out.println("정상적으로 삭제되지 않았습니다.");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally{
			disconnect();
		}
	}
	
	//단건조회 - 재고이름
	public Product slectOne(String productName) {	
		Product product = null;
		try {
			connect();
			String sql = "SELECT * FROM products WHERE product_name =?";
						//이름은 중복이 가능 -> 한건만 조회되도록 쿼리문 주의해야함!(자바 코드가 단건조회용임)
						//자바에서 컨트롤X 값을 들고오기만 함. 쿼리문에서 컨트롤해야함 (Developer에서 미리 돌려보자)
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product.getProductName());
			rs = pstmt.executeQuery();
			
			//값이 있을때 {}안의 내용 실행
			//if를 쓰든 while을 쓰든 마지막 행으로 계속 덮어쓴다 (리스트가 아니기때문)
			if(rs.next()) {
				product = new Product();
				product.setProductId(rs.getInt("product_id"));
				product.setProductName(rs.getString("product_name"));
				product.setProductPrice(rs.getInt("product_price"));
				product.setProductStock(rs.getInt("product_stock"));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally{
			disconnect();
		}
		return product;
	}
	
	//전체조회
	public List<Product> selectAll(){
		List<Product> list = new ArrayList<>();
		
		try {
			connect();
			String sql = "SELECT * FROM products ORDER BY product_id";
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Product product = new Product();
				product.setProductId(rs.getInt("product_id"));
				product.setProductName(rs.getString("product_name"));
				product.setProductPrice(rs.getInt("product_price"));
				product.setProductStock(rs.getInt("product_stock"));
				
				list.add(product);	//리스트에 넣어야함!!
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		
		return list;
	}
}
