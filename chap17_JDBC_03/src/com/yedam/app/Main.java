package com.yedam.app;
import java.util.List;
import com.yedam.app.product.Product;
import com.yedam.app.product.ProductDAO;
//언제나 ojdbc 잊지말것!
public class Main {

	public static void main(String[] args) {

		new StockManagement() ;
		
//		List<Product> list = ProductDAO.getInstance().selectAll();
//		for (Product pro : list) {
//			System.out.println(pro);
//		}

	}

}
