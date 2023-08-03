package member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.service.IMemberService;
import member.service.MemberServiceImpl;
import member.vo.MemberVO;


@WebServlet("/updateMember.do")
public class UpdateMember extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String memId = request.getParameter("id");
		IMemberService service = MemberServiceImpl.getInstance();
		
		MemberVO vo = service.getMember(memId);
		
		request.setAttribute("getMember", vo);
		
		request.getRequestDispatcher("/member/updateMember.jsp")
			.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		MemberVO vo = new MemberVO();
		
//		String id = (String)request.getAttribute("id");
		
//		vo.setMem_id(id);
		vo.setMem_id(request.getParameter("memId"));
		vo.setMem_pass(request.getParameter("memPass1"));
		vo.setMem_name(request.getParameter("memName"));
		vo.setMem_tel(request.getParameter("memTel"));
		vo.setMem_addr(request.getParameter("memAddr"));
		
		IMemberService service = MemberServiceImpl.getInstance();
		
		int cnt = service.updateMember(vo);
		
		response.sendRedirect(request.getContextPath()+"/memberList.do");
	}

}
