package cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/cookieCountDelServlet.do")
public class CookieCountDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset='utf-8'");
		
		PrintWriter out = response.getWriter();
		
		Cookie[] cookieArr = request.getCookies();
		if(cookieArr != null) {
			for(Cookie cookie : cookieArr) {
				if("count".equals(cookie.getName())){
					cookie.setMaxAge(0);
					response.addCookie(cookie);
				}
			}
		}
		
		out.println("<html><head><meta charset='utf-8'><title>쿠키Count연습</title></head>");
		out.println("<body>");
		out.println("<h3>count가 초기화 되었습니다.</h3>");
		out.println("<br><hr><br>");
		out.println("<a href='" + request.getContextPath() + "/cookie/cookieTest02.jsp'>시작 문서로 이동하기</a>");
		out.println("</body></html>");
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
