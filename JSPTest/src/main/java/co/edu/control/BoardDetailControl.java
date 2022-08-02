package co.edu.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.common.Controller;
import co.edu.common.HttpUtil;
import co.edu.dao.BoardDAO;
import co.edu.vo.BoardVO;

public class BoardDetailControl implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String bno = req.getParameter("id");
		BoardDAO dao = new BoardDAO();
		BoardVO vo = dao.searchBoard(Integer.parseInt(bno));
		
		req.setAttribute("board", vo);
		
		HttpUtil.forward(req, resp, "board/boardDetail.tiles");
		
	}

}
