package reqNresp;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/responseTest01.do")
public class ResponseTest01 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	/*
	-forward 방식			==> 컨트롤러(서블릿)가 뷰(jsp)한테 보낼 때 많이 사용함
					/ 예) 게시글 카테고리 들어감 -> 전체글 목록 보여줌-> 글쓰기누름-> 글쓰고 나면 저장한 후에는 전체글목록 페이지로 다시 가게만들때
		1)특정 문서에 대한 요청을 다른 서블릿이나 JSP로 넘겨준다.
		  (이 때 HttpServletRequest객체와 HttpServletResponse객체를 공유한다.)
		2)클라이언트의 요청 URL주소는 처음 요청할 때의 주소가 바뀌지 않는다.
			(A에서 B로 제어가 옮겨갈 때 처음 A를 가리켰던 주소는 변하지 않음-확인버튼 누르면 화면은 B화면이 나오지만 주소는 A주소임)
		3)서버 내부에서만 접근이 가능하다.
	 */
		
		//현재 페이지에서 만든 데이터를 이동하는 페이지로 전달 할 수 있다.
		//방법) Request객체의 setAttribute()메서드로 데이터를 셋팅하여 보내고 
		//		받는 쪽에서는 getAttribute()메서드로 데이터를 읽어온다.
		//보낼때 형식) Request객체.setAttribute("key값", 데이터);
		//			==>'key값'은 문자열로 지정하고, '데이터'는 Java의 모든 자료를 사용할 수 있다.
		request.setAttribute("tel", "010-1234-5678");
		
		//forward방식으로 이동하기
		//1. Request객체의 getRequestDispatcher()메서드에 이동할 서블릿이나 JSP를 지정해준다.
		//	(이 때 지정하는 주소는 전체 URI경로 중에서 ContextPath 이후의 경로를 지정해 준다.)
		
		//이동할 URI주소가 '/webTest/forwardTest.do'일 때
		//ContextPath인 '/webTest'를 생략한 주소를 지정한다.
		RequestDispatcher rd = request.getRequestDispatcher("/forwardTest.do");
		rd.forward(request, response);
				//B문서는 A문서와 request, response를 공유함 => JSP에서 username받는걸 B문서에서 할 수 있음
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
