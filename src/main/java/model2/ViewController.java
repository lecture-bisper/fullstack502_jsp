package model2;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "view", value = "/mvcboard/view.do")
public class ViewController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		지정한 게시물 정보를 가져오기 위한 DAO 클래스 객체 생성
		MVCBoardDAO dao = new MVCBoardDAO();
		
//		클라이언트에서 전달받은 게시물 번호 가져오기
		String idx = req.getParameter("idx");
		
//		게시물 조회수 증가
//		dao.updateVisitCount(idx);
		
//		DAO 에서 제공하는 selectView 메소드를 사용하여 게시물 정보를 MVCBoardDTO 타입으로 가져옴
		MVCBoardDTO board = dao.selectView(idx);
//		데이터베이스 접속 종료
		dao.close();
		
//		가져온 데이터 중 content 부분은 자바 문자열 타입으로 저장되어 있기 때문에 줄바꿈 기호가 html과 다름, 줄바꿈 기호를 html 방식으로 변경
		board.setContent(board.getContent().replace("\r\n", "<br>"));
		
//		저장된 파일명 가져오기
		String ext = null;
		String fileName = board.getSfile();
		
//		첨부파일 여부 확인
		if (fileName != null) {
//			확장자 명 분리
			ext = fileName.substring(fileName.lastIndexOf(".") + 1);
		}
		
//		분리된 확장자 명을 기준으로 이미지인지 아닌지 확인
		String[] mimeStr = {"png", "jpg", "gif"};
		List<String> mimeList = Arrays.asList(mimeStr);
		boolean isImage = false;
		
		if (mimeList.contains(ext)) {
			isImage = true;
		}
		
//		가져온 게시물 정보를 request 객체 저장
		req.setAttribute("board", board);
		req.setAttribute("isImage", isImage);
//		RequestDispatcher 로 지정한 jsp 파일로 포워드
		req.getRequestDispatcher("/14MVCBoard/View.jsp").forward(req, resp);
	}
}










