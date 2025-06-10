package fileupload;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;

public class FileUtil {
	//파일 업로드 처리
	public List<String> uploadFile(
			HttpServletRequest req,String sDirectory) 
					throws IOException, ServletException {
		//type이 file일 때는 Part 클래스를 사용해야 합니다.
		Part part=req.getPart("ofile");
		//헤더값에서 name속성과 파일명을 읽어 오기
		String partHeader=
				part.getHeader("content-disposition");
//		System.out.println(partHeader);
		//form-data; name="ofile"; filename="co.jpg"
		//헤더의 내용에서 파일명 추출
		String[] phArr=partHeader.split("filename=");
		//System.out.println(phArr[1]);
		//phArr[1]:"co.jpg"
		//공백과 큰따옴표 제거
		String originalFileName=
				phArr[1].trim().replace("\"", "");
		//System.out.println(originalFileName);
		//전송된 파일을 서버에 영구 저장
		//part.write()
//		System.out.println(sDirectory);
		String newFileName=renameFile(originalFileName);
		if(!originalFileName.isEmpty()) {
			part.write(sDirectory+File.separator+newFileName);
		}
		List<String> names=new ArrayList<>();
		names.add(originalFileName);
		names.add(newFileName);
		return names;
	}
	
	//파일명 변경
	public String renameFile(String fileName) {
		//확장자와 이름을 분리
//		System.out.println(fileName);
//		int i=fileName.lastIndexOf(".");
//		System.out.println(i);
		String ext=
			fileName.substring(
					fileName.lastIndexOf("."));
//		System.out.println(ext);
		String now=new SimpleDateFormat("yyyyMMdd_HmsS")
				.format(new Date());
//		System.out.println(now);
		String newFileName=now+ext;
		return newFileName;
	}
}