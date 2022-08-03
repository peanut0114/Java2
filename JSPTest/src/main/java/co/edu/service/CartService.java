package co.edu.service;

import java.util.List;

import co.edu.dao.CartDAO;
import co.edu.vo.CartVO;

public class CartService {

	// 싱글톤
	private static CartService instance = new CartService();

	private CartService() {
		}

	public static CartService getInstance() {
		return instance;
	}

	CartDAO dao = new CartDAO();
	
	//찜 리스트
	public List<CartVO> cartList() {
		return dao.cartList();
	}
	
	//수량변경
	public void updateCart(int no, int qty) {
		dao.updateCart(no,qty);
	}
}
