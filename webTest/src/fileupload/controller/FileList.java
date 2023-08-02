package fileupload.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fileupload.service.FileInfoServiceImpl;
import fileupload.service.IFileInfoService;
import vo.FileInfoVO;

//DB에 저장된 파일 목록을 가져와 View로 보내는 Servlet
@WebServlet("/fileList.do")
public class FileList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Service객체 생성
		IFileInfoService service = FileInfoServiceImpl.getInstance();
		
		// 전체 파일 목록을 가져와서 List에 담아준다.
		List<FileInfoVO> fileList = service.getAllFileInfo();
		
		//구해진 전체 파일 목록을 View페이지로 보낸다. (포워딩방식)
		request.setAttribute("fileList", fileList);
		
		request.getRequestDispatcher("/fileupload/fileList.jsp")
			.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
