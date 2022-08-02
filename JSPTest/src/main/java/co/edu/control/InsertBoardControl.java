package co.edu.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.edu.common.Controller;
import co.edu.common.HttpUtil;
import co.edu.service.BoardService;
import co.edu.vo.BoardVO;

public class InsertBoardControl implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BoardService service = BoardService.getInstance();
		HttpSession session = req.getSession();
		
		String title = req.getParameter("title");
		String writer = (String)session.getAttribute("id");
		String content = req.getParameter("content");

		BoardVO vo = new BoardVO();
		vo.setTitle(title);
		vo.setWriter(writer);
		vo.setContent(content);
		

		// insert
		service.addBoard(vo);

		req.setAttribute("board", vo);
	
		HttpUtil.forward(req, resp, "board/boardDetail.tiles");
	}

}
