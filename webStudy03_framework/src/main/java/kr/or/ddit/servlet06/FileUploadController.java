package kr.or.ddit.servlet06;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.commons.io.FileUtils;

import kr.or.ddit.filter.wrapper.FileUploadRequestWrapper;
import kr.or.ddit.filter.wrapper.PartWrapper;
import kr.or.ddit.mvc.annotation.CommandHandler;
import kr.or.ddit.mvc.annotation.HttpMethod;
import kr.or.ddit.mvc.annotation.URIMapping;

@CommandHandler
public class FileUploadController {
	@URIMapping(value="/fileUpload.do", method=HttpMethod.POST)
	public String doPost(HttpSession session, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//서버에서 get방식도 인코딩 되도록 설정해놔서 post가 아님에도 인코딩이 되는 것. setCharacterEncoding은 원칙적으로 body에서 인코딩되는것
		//필터에서 인코딩 방식으로 바꿔서 이제 인코딩 코드 필요가 없어짐
		//req.setCharacterEncoding("UTF-8"); 
		String uploader = req.getParameter("uploader");
		//String uploadeFile  = req.getParameter("uploadeFile");
		if(req instanceof FileUploadRequestWrapper) {
			//파일 업로드
			String folderURL = "/images";
			String folderPath =  req.getServletContext().getRealPath(folderURL);
			File folder = new File(folderPath);
			
			List<PartWrapper> list = ((FileUploadRequestWrapper) req).getPartWrappers("uploadeFile");
			if(list!=null) {
				List<String> saveURLs = new ArrayList<>();
				session.setAttribute("saveURLs", saveURLs);
				for(PartWrapper wrapper : list) {
					wrapper.saveToRealPath(folder);
					
					System.out.printf("uploader : %s, uploadeFile : %s, uploadedURL : %s\n", 
							uploader, wrapper.getOriginalFilename(), folderURL+"/"+wrapper.getSaveName());
					saveURLs.add(folderURL+"/"+wrapper.getSaveName());
				} //for end
			} //list!=null end
		}
		return "redirect:/13/fileUploadForm.jsp";
		
//		Part uploadeFilePart = req.getPart("uploadeFile");
//		
//		if(!uploadeFilePart.getContentType().startsWith("image/")) { //파일의 mime을 알 수 있음
//			resp.sendError(400, "이미지 외에는 업로드 불가.");
//			return;
//		}						
//		Content-Disposition: form-data; name="uploadeFile"; filename=""
//		String headerValue = uploadeFilePart.getHeader("Content-Disposition");
//		int index = headerValue.indexOf("filename");
//		index = headerValue.indexOf("=", index);
//		headerValue = headerValue.substring(index+1);
//		String fileName = headerValue.replace("\"", ""); //원본 파일명
//		String savename = UUID.randomUUID().toString(); //해킹을 막기위해 원본 이름을 쓰지 말고, 확장자를 없애라..
//		File saveFile = new File(folder, savename);
//		
//		//파일 읽기
//		try(		
//			InputStream is = uploadeFilePart.getInputStream();
//		){
//			FileUtils.copyInputStreamToFile(is, saveFile);
//		}
		
		
	}
}
