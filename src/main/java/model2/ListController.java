package model2;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// index.jsp 의 a 태그에 입력해 놓은 url인 '/mvcboard/list.do' 를 사용할 수 있도록 서블릿에 등록
//	@WebServlet 어노테이션을 사용하여 해당 클래스가 서블릿 파일임을 jsp에 알려줌

//	ListController 클래스는 HttpServlet 클래스를 상속받아서 서블릿으로 동작함
@WebServlet(name = "list", value = "/mvcboard/list.do")
public class ListController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		게시판용 데이터베이스 연결 및 데이터 요청관리
		MVCBoardDAO dao = new MVCBoardDAO();
		
		Map<String, Object> map = new HashMap<String, Object>();
		
//		클라이언트가 서버로 요청 시 전달한 데이터 가져오기
		String searchField = req.getParameter("searchField");
		String searchWord = req.getParameter("searchWord");
		
//		검색어가 존재 시
		if (searchWord != null) {
//			HashMap 타입의 객체에 클라이언트에서 전달받은 데이터 저장
			map.put("searchField", searchField);
			map.put("searchWord", searchWord);
		}
		
//		전체 게시물 수 가져오기
		int totalCount = dao.selectCount(map);
		
//		ServletContext application = getServletContext();
//		int pageSize = Integer.parseInt(application.getInitParameter("POSTS_PER_PAGE"));
//		int blockPage = Integer.parseInt(application.getInitParameter("PAGES_PER_BLOCK"));
//		한 페이지에 출력할 게시물 수 설정
		int pageSize = 10;
//		한 블럭당 표시할 페이지 수 설정
		int blockPage = 5;
		
//		현재 페이지 번호
		int pageNum = 1; // 기본값 1 설정
//		클라이언트에서 전달한 값 중 pageNum 의 값을 가져옴
		String pageTemp = req.getParameter("pageNum");
//		pageNum 이 null 이거나 빈 문자열인지 확인
		if (pageTemp != null && !pageTemp.equals("")) {
			pageNum = Integer.parseInt(pageTemp);
		}
		
		int start = (pageNum - 1) * pageSize + 1;
		int end = pageNum * pageSize;
		map.put("start", start);
		map.put("end", end);
		
//		게시물 목록 가져오기
		List<MVCBoardDTO> boardList = dao.selectListPage(map);
//		데이터베이스 연결 종료
		dao.close();
		
//		페이지 이동 네비게이션 바 생성
		String pagingImg = BoardPage.pagingStr(totalCount, pageSize, blockPage, pageNum, "../mvcboard/list.do");
		
		map.put("pagingImg", pagingImg);
		map.put("totalCount", totalCount);
		map.put("pageSize", pageSize);
		map.put("pageNum", pageNum);
		
//		request 객체에 가져온 게시물 목록을 저장
		req.setAttribute("boardList", boardList);
//		request 객체에 페이지 정보를 저장
		req.setAttribute("map", map);
//		RequestDispatcher 를 사용하여 지정한 jsp 페이지로 포워드
		req.getRequestDispatcher("/14MVCBoard/List.jsp").forward(req, resp);
		
	}

}









