package co.edu.control;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import co.edu.common.Controller;
import co.edu.service.CartService;
import co.edu.vo.CartVO;
//ajax 연습
public class CartListControl implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//만들어지는 컨텐트 타입을 알려줌
		resp.setContentType("text/json;charset=utf-8");
		
		// DAO 메소드, MemberService 메소드
		// json형태로 반환
		CartService service = CartService.getInstance();
		List<CartVO> cartList = service.cartList();
		System.out.println(cartList);
		Gson gson = new GsonBuilder().create();
		resp.getWriter().print(gson.toJson(cartList));	//json 형태로 넘겨줌
	}

}
