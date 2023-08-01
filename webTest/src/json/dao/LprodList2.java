package json.dao;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import json.service.ILprodService;
import json.service.LprodServiceImpl;
import vo.LprodVO;



@WebServlet("/lprodList2.do")
public class LprodList2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		ILprodService service = LprodServiceImpl.getInstance();
		
		//DB에서 원하는 작업을 수행한다. (Service객체 이용)
		List<LprodVO> lprodList = service.getLprod();
		
		//작업 결과를 Request객체에 저장한다.
		request.setAttribute("lprodList", lprodList);
		
		//View페이지로 forwarding한다.
		request.getRequestDispatcher("/json/lprodView.jsp")
			.forward(request, response);
		
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
