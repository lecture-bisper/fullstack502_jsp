package model2;

import java.io.IOException;

import fileupload.FileUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

// 수정 및 삭제 시 등록된 비밀번호와 같을 경우에만 진행할 수 있도록 비밀번호 확인
@WebServlet(name = "pass", value = "/mvcboard/pass.do")
public class PassController extends HttpServlet {

	private static final long serialVersionUID = 1L;

//	사용자가 비밀번호를 입력하기 위한 페이지
	@Override
	protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		View.jsp 에서 전달한 파라미터 mode 의 값을 가져옴, request 객체에 저장
		req.setAttribute("mode", req.getParameter("mode"));
//		RequestDispatcher 를 사용하여 지정한 Pass.jsp 파일로 포워드
		req.getRequestDispatcher("/14MVCBoard/Pass.jsp").forward(req, resp);
	}
	
//	사용자가 입력한 비밀번호가 데이터베이스에 저장된 비밀번호와 같은지 비교
	@Override
	protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		클라이언트에서 전달한 데이터 가져오기
		String idx = req.getParameter("idx"); // 게시글 번호
		String mode = req.getParameter("mode"); // 모드 값 (delete, edit)
		String pass = req.getParameter("pass"); // 사용자 비밀번호
		
//		데이터베이스 제어를 위한 DAO 객체 생성
		MVCBoardDAO dao = new MVCBoardDAO();
//		DAO에서 제공하는 confirmPassword 메소드를 사용하여 입력한 비밀번호와 일치하는지 여부 확인
		boolean result = dao.confirmPassword(pass, idx);
		
//		비밀번호가 일치하는지 확인
		if (result == true) {
			
//			비밀번호가 일치하면 mode의 값이 edit 인지 delete 인지 확인
			if (mode.equals("edit")) {
//				데이터베이스 접속 종료
				dao.close();
				
//				세션 생성
				HttpSession session = req.getSession();
//				세션에 데이터 저장, 아래에서 리다이렉트를 사용하여 지정한 url로 재접속하기 때문에 request 영역에 저장된 데이터가 삭제됨, 세션에 저장 시 데이터가 계속 살아있음
				session.setAttribute("pass", pass);
//				/mvcboard/edit.do 서블릿으로 리다이렉트, 지정한 url 로 재접속
				resp.sendRedirect("../mvcboard/edit.do?idx=" + idx);
			}
			else if (mode.equals("delete")) {
//				mode 값이 delete 이면
//				게시물 정보를 데이터베이스에서 가져옴
				MVCBoardDTO board = dao.selectView(idx);
//				DAO 에서 제공하는 deletePost 메소드를 사용하여 지정한 게시물 삭제
				int deleteResult = dao.deletePost(idx);
				dao.close();
				
//				데이터베이스에서 받아온 결과값이 1과 같은지 확인
				if (deleteResult == 1) {
					
//					결과값이 1과 같을 경우 저장된 첨부파일 삭제
					String saveFileName = board.getSfile();
					FileUtil.deleteFile(req, "/Upload", saveFileName);
				}
				
//				자바스크립트로 알림창 출력 후 목록 페이지로 이동
				JSFunction.alertLocation(resp, "삭제되었습니다.", "../mvcboard/list.do");
			}
		}
		else {
			dao.close();
//			비밀번호가 일치하지 않으면 자바스크립트로 알림창 출력 후 뒤로가기
			JSFunction.alertBack(resp, "비밀번호가 다릅니다.");
		}
	}
}












