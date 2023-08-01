package json;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.google.gson.Gson;

import json.service.ILprodService;
import json.service.LprodServiceImpl;
import vo.LprodVO;
import util.MybatisUtil;


@WebServlet("/lprodList.do")
public class LprodList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ILprodService service = LprodServiceImpl.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		List<LprodVO> list = service.getLprod();
		Gson gson = new Gson();
		String jsonData = "";
		
		jsonData = gson.toJson(list);
		PrintWriter out = response.getWriter();

		System.out.println(jsonData);
		out.print(jsonData);
		response.flushBuffer();

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
