package fileupload;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/13FileUpload/UploadProcess.do")
//파일업로드를 처리하기 위한 서블릿 구성 애너테이션
@MultipartConfig(
	maxFileSize=1024*1024*20,
	maxRequestSize=1024*1024*200
)
public class UploadProcess extends HttpServlet{
	MyFileService mfs=new MyFileService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//파일 저장 하기
		//저장할 폴더
		String saveDirectory=
				getServletContext().getRealPath("/Uploads");
		List<String> names=mfs.saveFile(req, saveDirectory);
		//데이터 베이스에 정보 저장
		mfs.insertMyFile(req, names);
		//view로 리다이렉트
		req.getRequestDispatcher("FileUploadMain.jsp")
			.forward(req, resp);
	}
	
}








