package reqNresp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/forwardTest.do")
public class ForwardTest extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//POST방식의 인코딩 방식 설정
		request.setCharacterEncoding("utf-8");
		
		//파라미터로 전달되는 데이터 받기
		String userName = request.getParameter("username");
				//B문서는 A문서와 request, response를 공유함 => JSP에서 username받는걸 B문서에서 할 수 있음
		
		//이전 문서에서 setAttribute()메서드로 셋팅한 데이터 받기
		//받을 때 형식) Request객체.getAttribute("key값")
		String tel = (String)request.getAttribute("tel");
		
		//응답 처리
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html><head><meta charset='utf-8'><title>Forward 연습</title></head>");
		out.println("<body>");
		out.println("<h3>Forward 이동 결과</h3><hr>");
		out.println("<table border='1'>");
		out.println("<tr><td>이 름</td>");
		out.println("<td>"+userName+"</td></tr>");
		out.println("<tr><td>전  화</td>");
		out.println("<td>"+tel+"</td></tr>");
		out.println("</table>");
		out.println("</body></html>");
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
