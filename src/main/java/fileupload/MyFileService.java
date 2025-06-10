package fileupload;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;

public class MyFileService {
	FileUtil fu=new FileUtil();
	MyFileDAO mfdao=new MyFileDAO();
	
	public List<String> saveFile(HttpServletRequest req,String saveDirectory) throws IOException, ServletException {
		
//		System.out.println(saveDirectory);
		//String saveDirectory="Uploads";
		//원래 파일 이름과 새로운 이름
		List<String> names=fu.uploadFile(req, saveDirectory);
		return names;
	}
	
	//db에 파일 업로드 정보 저장
	public void insertMyFile(
			HttpServletRequest req,
			List<String> names) {
		String title=req.getParameter("title");
		String cate=req.getParameter("cate");
		MyFileDTO mfd=new MyFileDTO();
		mfd.setTitle(title);
		mfd.setCate(cate);
		mfd.setOfile(names.get(0));
		mfd.setSfile(names.get(1));
		mfdao.insertFile(mfd);
	}
	
	public List<MyFileDTO> getMyFiles() {
		return mfdao.getMyFiles();
	}

}





