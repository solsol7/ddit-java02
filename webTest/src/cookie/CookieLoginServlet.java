package cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookieLoginServlet.do")
public class CookieLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		response.setCharacterEncoding("utf-8");
//		response.setContentType("text/html; charset='utf-8'");
		request.setCharacterEncoding("utf-8");
		String check = request.getParameter("check");

		String id = request.getParameter("id");
		String pass = request.getParameter("pass");

		Cookie[] cookieArr = request.getCookies();
		
		Cookie c1= null;

		if (cookieArr == null) {
			Cookie cookie = new Cookie("id", id);
			response.addCookie(cookie);
		} else {
			for (Cookie cookie : cookieArr) {
				if ("id".equals(cookie.getName())) {
					cookie.setValue(id);
					response.addCookie(cookie);
					c1=cookie;
				}
			}
		}

		

		if ("test".equals(id) && "1234".equals(pass)) {
			RequestDispatcher rd = request.getRequestDispatcher("cookie/cookieMain.jsp");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("cookie/cookieLogin.jsp");
			rd.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
