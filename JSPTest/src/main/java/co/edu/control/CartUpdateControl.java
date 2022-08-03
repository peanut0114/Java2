package co.edu.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.common.Controller;
import co.edu.service.CartService;

public class CartUpdateControl implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String no = req.getParameter("no");
		String qty = req.getParameter("qty");
		
		CartService service = CartService.getInstance();
		//받아온 no값과 qty 값을 DB에 반영 (update)
		service.updateCart(Integer.parseInt(no), Integer.parseInt(qty));
		
		resp.getWriter().print("success");	//성공 넘겨줘서 성공하면~~, 실패하면~~ 처리
		
	}

}
