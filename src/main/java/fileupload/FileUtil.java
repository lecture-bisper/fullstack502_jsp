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
	
	public static String uploadFile2(HttpServletRequest req,String sDirectory) throws IOException, ServletException {
		//type이 file일 때는 Part 클래스를 사용해야 합니다.
		Part part=req.getPart("ofile");
		//헤더값에서 name속성과 파일명을 읽어 오기
		String partHeader= part.getHeader("content-disposition");
//		System.out.println(partHeader);
		//form-data; name="ofile"; filename="co.jpg"
		//헤더의 내용에서 파일명 추출
		String[] phArr = partHeader.split("filename=");
		//System.out.println(phArr[1]);
		//phArr[1]:"co.jpg"
		//공백과 큰따옴표 제거
		String originalFileName = phArr[1].trim().replace("\"", "");
		
//		파일명이 비었는지 확인
		if (!originalFileName.isEmpty()) {
//			업로드할 실제 경로와 원본 파일명을 합쳐서 실제 디스크에 저장
//			File.separator : / 를 표시
			part.write(sDirectory + File.separator + originalFileName);
		}
		
//		분리된 원본 파일명 반환
		return originalFileName;
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
	
	public static String renameFile2(String saveDir, String fileName) {
		
		String ext = fileName.substring(fileName.lastIndexOf("."));

//		현재 날짜 및 시간으로 새 파일명을 설정
		String now = new SimpleDateFormat("yyyyMMdd_HmsS").format(new Date());
		
		String newFileName = now + ext;
		
//		원본 파일명을 새 파일명으로 변경
		File oldFile = new File(saveDir + File.separator + fileName);
		File newFile = new File(saveDir + File.separator + newFileName);
		
//		실제 디스크에 저장되어 있는 원본 파일명을 날짜 및 시간 기준의 새 파일명으로 변경
		oldFile.renameTo(newFile);
		
//		변경된 새 파일명을 반환
		return newFileName;
	}
	
}





