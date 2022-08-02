package co.edu.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.edu.common.Controller;
import co.edu.common.HttpUtil;

public class AddBoardControl implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if(session != null&& session.getAttribute("id")==null) {
			HttpUtil.forward(req, resp, "member/memberLoginForm.tiles");
		}
		HttpUtil.forward(req, resp, "/board/boardAddForm.tiles");

	}

}
