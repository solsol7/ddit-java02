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
		request.setCharacterEncoding("utf-8");
		
		// userid, userpass, chkid 값 받기
		String userId = request.getParameter("userid");
		String pass = request.getParameter("userpass");
		String chkid = request.getParameter("chkid");
		
		// userId를 쿠키값으로 갖는 Cookie객체 생성 (쿠키이름 : USERID )
		Cookie userCookie = new Cookie("USERID",userId);
		
		System.out.println("체크박스의 체크 여부 : "+chkid);
		
		// 체크박스의 체크 여부에 따라 쿠키 저장 확인
		if(chkid!=null) {	// 체크박스가 체크되었을 때
			response.addCookie(userCookie);	// 쿠키 저장
		}else {
			userCookie.setMaxAge(0);
			response.addCookie(userCookie);	// 쿠키 삭제
		}
		
		if("test".equals(userId) && "1234".equals(pass)) { //로그인 성공
			response.sendRedirect(request.getContextPath()+"/cookie/cookieMain.jsp");
		}else {
			response.sendRedirect(request.getContextPath()+"/cookie/cookieLogin.jsp");
		}

	}
	
	
	
/*
//		response.setCharacterEncoding("utf-8");
//		response.setContentType("text/html; charset='utf-8'");
		request.setCharacterEncoding("utf-8");
		String check = request.getParameter("check");

		String id = request.getParameter("id");
		String pass = request.getParameter("pass");

		Cookie[] cookieArr = request.getCookies();
		
		Cookie c1= null;


		for (Cookie c : cookieArr) {
			if (!"id".equals(c.getName())){
				Cookie cookie = new Cookie("id", id);
				response.addCookie(cookie);
			}else if("id".equals(c.getName())){
				Cookie cookie = c;
				cookie.setValue(id);
				response.addCookie(cookie);
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
*/

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

