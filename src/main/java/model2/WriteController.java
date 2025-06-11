package model2;

import java.io.IOException;

import fileupload.FileUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// WebServlet 어노테이션을 사용하여 서블릿 설정, url 설정
@WebServlet(name = "write", value = "/mvcboard/write.do")
// 업로드하는 파일의 크기 설정, 기본 단위가 byte, 파일당 1MB, 총 파일의 크기는 10MB
@MultipartConfig(maxFileSize = 1024 * 1024 * 1, maxRequestSize = 1024 * 1024 * 10)
public class WriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

//	get 방식으로 접속 시 사용
//	사용자 입력을 위한 단순 웹 페이지 출력
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		RequestDispatcher 로 지정한 jsp 파일로 포워드
		req.getRequestDispatcher("/14MVCBoard/Write.jsp").forward(req, resp);
	}
	
//	post 방식으로 접속 시 사용
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		파일 업로드 관련
//		실제 파일 업로드 경로를 생성
		String saveDir = req.getServletContext().getRealPath("/Upload");
		
//		업로드 파일 이름 설정, 기본값 빈문자열
		String oriFileName = "";
		
		try {
//			FileUtil 의 uploadFile2 메소드를 이용하여 파일명 분리
			oriFileName = FileUtil.uploadFile2(req, saveDir);
		}
		catch(Exception e) {
			JSFunction.alertLocation(resp, "파일 업로드 오류입니다.", "../mvcboard/write.do");
			return;
		}
		
//		데이터베이스에 게시글 등록
		MVCBoardDTO board = new MVCBoardDTO();
		
//		클라이언트에서 전달받은 사용자 입력 내용을 MVCBoardDTO 타입의 객체에 저장
		board.setName(req.getParameter("name"));
		board.setTitle(req.getParameter("title"));
		board.setContent(req.getParameter("content"));
		board.setPass(req.getParameter("pass"));
		
//		업로드된 파일 여부 확인
		if (oriFileName != "") {
//			업로드된 파일이 있을 경우 파일 이름 변경
			String saveFileName = FileUtil.renameFile2(saveDir, oriFileName);
			
//			원본 파일명과 새 파일명을 MVCBoardDTO 타입의 객체에 저장
			board.setOfile(oriFileName);
			board.setSfile(saveFileName);
		}
		
//		데이터베이스 제어를 위한 MVCBoardDAO 타입의 객체 생성
		MVCBoardDAO dao = new MVCBoardDAO();
		
//		MVCBoardDAO 에서 제공하는 insertWrite 메소드를 사용하여 MVCBoardDTO 타입의 객체를 데이터베이스에 등록, 결과값 받아옴
		int result = dao.insertWrite(board);
//		데이터베이스 접속 종료
		dao.close();
		
//		데이터베이스 실행 결과를 바탕으로 이동할 페이지 설정
		if (result == 1) {
//			성공 시 게시물 목록 페이지로 리다이렉트
			resp.sendRedirect("../mvcboard/list.do");
		}
		else {
//			실패 시 게시물 등록 페이지로 이동
			JSFunction.alertLocation(resp, "게시글 등록에 실패했습니다", "../mvcboard/write.do");
		}
	}

}










