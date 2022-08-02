package co.edu.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.edu.common.Controller;
import co.edu.common.HttpUtil;
import co.edu.service.MemberService;
import co.edu.vo.MemberVO;

public class MemberLoginControl implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 로그인 성공 시 memberLoginSuccess.jsp로 이동.
		// 로그인 실패 시 memberLoginFail.jsp로 이동.
		
		//로그아웃
		HttpSession session = req.getSession(false);	//없으면 null리턴
		if(session != null&& session.getAttribute("id")!=null) {//로그인 한 상태
			System.out.println("logout.");
			session.invalidate();	//세션삭제
			HttpUtil.forward(req, resp, "index.jsp");
		}
		
		//로그인
		String id = req.getParameter("memberId");
		String pw = req.getParameter("memberPassword");
		
		MemberService service = MemberService.getInstance();
		MemberVO vo = service.getMember(id);
		
		//로그인 실패 : id가 없거나 pw가 맞지 않는 경우
		if(vo==null) {
			System.out.println("아이디가 없습니다");
			HttpUtil.forward(req, resp, "member/memberLoginFail.tiles");
		} 
		else if(!vo.getPasswd().equals(pw)) {
			System.out.println("패스워드가 맞지 않습니다");
			HttpUtil.forward(req, resp, "member/memberLoginFail.tiles");
		}
		else {
			//로그인 성공
			System.out.println("login.");
			session.setAttribute("id", id);
			req.setAttribute("member", vo);
			HttpUtil.forward(req, resp,"member/memberLoginSuccess.tiles");
		}
	}

}
