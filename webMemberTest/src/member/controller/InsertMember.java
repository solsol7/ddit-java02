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


@WebServlet("/insertMember.do")
public class InsertMember extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/member/insertMember.jsp")
		.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		response.setContentType("text/html; charset=utf-8");
		
		MemberVO vo = new MemberVO();
		
		vo.setMem_id(request.getParameter("memId"));
		vo.setMem_pass(request.getParameter("memPass1"));
		vo.setMem_name(request.getParameter("memName"));
		vo.setMem_tel(request.getParameter("memTel"));
		vo.setMem_addr(request.getParameter("memAddr"));

		
		IMemberService service = MemberServiceImpl.getInstance();
		
		int cnt = service.insertMember(vo);
	
		
//		response.sendRedirect(request.getContextPath()+"/");
		
		request.getRequestDispatcher("/memberList.do")
		.forward(request, response);
	}

}
