package co.edu.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import co.edu.common.Controller;
import co.edu.common.HttpUtil;
import co.edu.service.MemberService;
import co.edu.vo.MemberVO;

public class MemberJoinControl implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 회원가입화면: 회원가입 후 첫페이지로 이동.
		MemberService service = MemberService.getInstance();
		
		String id = req.getParameter("memberId");
		String pw = req.getParameter("memberPassword");
		String nm = req.getParameter("memberName");
		String ad = req.getParameter("memberAddress");

		MemberVO vo = new MemberVO();
		vo.setId(id);
		vo.setName(nm);
		vo.setPasswd(pw);
		vo.setAddr(ad);

		// insert
		service.addMember(vo);

		// 요청처리 결과 뷰페이지 전송 (vo의 주소값을 member이름으로 담음)
		req.setAttribute("member", vo);
	
		HttpUtil.forward(req, resp, "index.jsp");
	}

}
