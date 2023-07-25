package reqNresp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/requestTest02.do")
public class RequestTest02 extends HttpServlet{
	 @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int num1=  Integer.parseInt(request.getParameter("num1"));
		String op = request.getParameter("op");
		int num2= Integer.parseInt(request.getParameter("num2"));
		double result=0;
		switch (op) {
		case "+":
			result=num1+num2; break;
		case "-":
			result=num1-num2; break;
		case "*":
			result=num1*num2; break;
		case "/":
			result=num1/num2; break;
		case "%":
			result=num1%num2; break;
		default:
			break;
		}
		
		//-----------------------------------------------------
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html><head><meta charset='utf-8'><title></title>");
		out.println("</head>");
		out.println("<body><h2>계산 결과</h2>");
		out.println("<hr>");
		out.println("<div>");
		out.print(num1+op+num2+"="+result);
//		out.println(Integer.parseInt(num1)*Integer.parseInt(num2));
		out.println("</div>");
		out.println("</body></html>");
		
	}
}
