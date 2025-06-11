package model2;

import java.io.IOException;

import fileupload.FileUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "edit", value = "/mvcboard/edit.do")
@MultipartConfig(maxFileSize = 1024 * 1024 * 1, maxRequestSize = 1024 * 1024 * 10)
public class EditController extends HttpServlet {

	private static final long serialVersionUID = 1L;

//	사용자 데이터 입력을 위한 페이지 출력
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		클라이언트에서 전달받은 게시물 번호 가져오기
		String idx = req.getParameter("idx");
		
//		데이터베이스 제어를 위한 DAO 객체 생성
		MVCBoardDAO dao = new MVCBoardDAO();
//		DAO 에서 제공하는 selectView 메소드를 사용하여 MVCBoardDTO 타입의 객체 생성 및 데이터 저장
		MVCBoardDTO board = dao.selectView(idx);
		
//		request 영역에 가져온 게시물 정보 저장
		req.setAttribute("board", board);
		req.getRequestDispatcher("/14MVCBoard/Edit.jsp").forward(req, resp);
	}
	
//	사용자가 입력한 데이터를 데이터베이스에 입력
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		첨부파일 처리 부분
//		디스크에 실제 저장될 경로 가져오기
		String saveDir = req.getServletContext().getRealPath("/Upload");
		
//		원본 파일명 가져오기
		String oriFileName = "";
		try {
			oriFileName = FileUtil.uploadFile2(req, saveDir);
		}
		catch (Exception e) {
			JSFunction.alertBack(resp, "파일 업로드 오류 입니다.");
			return;
		}
		
//		클라이언트에서 전달받은 데이터 가져오기
		String idx = req.getParameter("idx"); // 게시물 번호
		String prevOfile = req.getParameter("prevOfile"); // 기존 첨부파일 원본 이름
		String prevSfile = req.getParameter("prevSfile"); // 기존 첨부파일 저장 이름
		
//		클라이언트에서 전달받은 수정된 데이터 가져오기
		String name = req.getParameter("name");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
//		request 객체에서 세션 가져오기
		HttpSession session = req.getSession();
//		세션에 저장된 비밀번호 가져오기
		String pass = (String)session.getAttribute("pass");
		
//		데이터베이스에 저장하기 위한 MVCBoardDTO 객체 생성
		MVCBoardDTO board = new MVCBoardDTO();
//		dto 객체에 데이터 저장
		board.setIdx(idx);
		board.setName(name);
		board.setTitle(title);
		board.setContent(content);
		board.setPass(pass);
		
//		첨부파일 여부 확인
		if (oriFileName != null && !oriFileName.equals("")) {
//			첨부 파일이 있으면 저장된 파일의 이름 변경
			String saveFileName = FileUtil.renameFile2(saveDir, oriFileName);
			
//			dto 객체에 파일 정보 저장
			board.setOfile(oriFileName);
			board.setSfile(saveFileName);
			
//			기존 파일 디스크에서 삭제
			FileUtil.deleteFile(req, "/Upload", prevSfile);
		}
		else {
//			첨부 파일이 없으면 기존 파일 정보를 dto 객체에 저장
			board.setOfile(prevOfile);
			board.setSfile(prevSfile);
		}
		
//		데이터베이스 제어를 위해서 DAO 객체 생성
		MVCBoardDAO dao = new MVCBoardDAO();
//		DAO 에서 제공하는 updatePost 메소드로 새 데이터로 수정 및 결과 가져오기
		int result = dao.updatePost(board);
		dao.close();
		
//		수정 결과가 1인지 아닌지 확인
		if (result == 1) {
//			결과가 1이면 세션에 저장된 비밀번호 삭제
			session.removeAttribute("pass");
//			리다이렉트를 통해서 수정된 내용을 상세 페이지에서 출력
			resp.sendRedirect("../mvcboard/view.do?idx=" + idx);
		}
		else {
//			결과가 1이 아니면 자바스크립트로 비밀번호 검증부터 다시 시작
			JSFunction.alertLocation(resp, "비밀번호 검증을 다시 진행하세요", "../mvcboard/view.do?idx=" + idx);
		}
	}
	
}












