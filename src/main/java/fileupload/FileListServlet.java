package fileupload;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/13FileUpload/FileList.do")
public class FileListServlet extends HttpServlet{
	
	MyFileService mfs=new MyFileService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<MyFileDTO> mfdtos= mfs.getMyFiles();
		req.setAttribute("mfdtos", mfdtos);
		req.getRequestDispatcher("FileList.jsp")
			.forward(req, resp);
	}

}





