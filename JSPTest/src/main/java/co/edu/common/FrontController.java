package co.edu.common;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.control.AddBoardControl;
import co.edu.control.AjaxMemberIdCheck;
import co.edu.control.BoardDetailControl;
import co.edu.control.BoardListControl;
import co.edu.control.BoardListPagingControl;
import co.edu.control.InsertBoardControl;
import co.edu.control.MainController;
import co.edu.control.MemberJoinControl;
import co.edu.control.MemberJoinFormControl;
import co.edu.control.MemberLoginControl;
import co.edu.control.MemberLoginFormControl;

public class FrontController extends HttpServlet {

	String charset = null;
	HashMap<String, Controller> mappings = null;

	@Override
	public void init(ServletConfig config) throws ServletException {

		charset = config.getInitParameter("charset");
		mappings = new HashMap<String, Controller>();
		mappings.put("/main.do", new MainController());
		mappings.put("/memberLoginForm.do", new MemberLoginFormControl()); // 로그인화면.
		mappings.put("/memberLoginOut.do", new MemberLoginControl()); // 로그인,로그아웃 처리.
		mappings.put("/memberJoinForm.do", new MemberJoinFormControl()); // 회원가입화면.
		mappings.put("/memberJoin.do", new MemberJoinControl()); // 회원가입화면.
		mappings.put("/ajaxMemberIdCheck.do", new AjaxMemberIdCheck()); // 아이디 중복 체크.
		mappings.put("/addBoard.do", new AddBoardControl()); // 게시글 등록화면
		mappings.put("/insertBoard.do", new InsertBoardControl()); // 게시글 등록처리
		mappings.put("/boardList.do", new BoardListControl()); // 게시글 목록
		mappings.put("/boardDetail.do", new BoardDetailControl());// 게시글 상세페이지
		mappings.put("/boardListPaging.do", new BoardListPagingControl());	//게시글목록 페이징
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding(charset);

		String url = req.getRequestURI();
		String contextPath = req.getContextPath();
		String path = url.substring(contextPath.length());
		System.out.println(path);

		Controller subControl = mappings.get(path);
		subControl.execute(req, resp);

	}
}
