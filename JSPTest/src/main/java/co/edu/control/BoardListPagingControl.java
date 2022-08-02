package co.edu.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.common.Controller;
import co.edu.common.HttpUtil;
import co.edu.service.BoardService;
import co.edu.vo.BoardVO;
import co.edu.vo.Criteria;
import co.edu.vo.Page;

public class BoardListPagingControl implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 페이징 처리 된 리스트 출력
		// 서비스 -> DAO 구현
		
		String pageNum = req.getParameter("pageNum");
		String amount = req.getParameter("amount");
		
		Criteria cri = new Criteria();	//1,10건
		cri.setPageNum(Integer.parseInt(pageNum));	
		cri.setAmount(Integer.parseInt(amount));
		
		BoardService service = BoardService.getInstance();
		List<BoardVO> pagdList = service.getListPaging(cri);
		
		req.setAttribute("list", pagdList);	//10건씩 보여주는 페이지 
		
		List<BoardVO> totalList = service.boardList();
		int total = totalList.size();
		req.setAttribute("pageInfo", new Page(cri,total));	//현재페이지, 시작, 마지막페이지
		
		HttpUtil.forward(req, resp, "board/boardList.tiles");

	}

}
