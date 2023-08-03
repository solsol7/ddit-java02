package member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import member.service.IMemberService;
import member.service.MemberServiceImpl;
import member.vo.MemberVO;


@WebServlet("/memberDetail.do")
public class MemberDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		IMemberService service = MemberServiceImpl.getInstance();
		
		String memId = request.getParameter("id");
		
		MemberVO vo = service.getMember(memId);

		request.setAttribute("getMember", vo);
		
		request.getRequestDispatcher("/member/memberDetail.jsp")
				.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		IMemberService service = MemberServiceImpl.getInstance();
		
		String memId = request.getParameter("id");
		
		MemberVO vo = service.getMember(memId);

		Gson gson = new Gson();
		String jsonData = gson.toJson(vo);
		
		PrintWriter out = response.getWriter();
		out.print(jsonData);
		
	}

}
