package member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.service.IMemberService;
import member.service.MemberServiceImpl;

@WebServlet("/deleteMember.do")
public class DeleteMember extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
	
		String memId = request.getParameter("id");
		
		IMemberService service = MemberServiceImpl.getInstance();
		
		int cnt = service.deleteMember(memId);
		
		response.sendRedirect(request.getContextPath()+"/memberList.do");
		//왜 forward로 하면 안됨?
		
//		request.getRequestDispatcher(request.getContextPath()+"/member/memberList.jsp")
//			.forward(request, response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
