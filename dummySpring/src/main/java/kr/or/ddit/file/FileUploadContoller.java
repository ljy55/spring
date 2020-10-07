package kr.or.ddit.file;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.DeleteGroup;
import kr.or.ddit.InsertGroup;
import kr.or.ddit.vo.FileUploadVO;

@Controller
@RequestMapping("/fileUpload")
public class FileUploadContoller {
	@Inject
	WebApplicationContext context;
	File uploadFolder;
	
	@PostConstruct
	public void init() {
		String realPath = context.getServletContext().getRealPath("/resources/uploadFolder");
		uploadFolder = new File(realPath);
		if(!uploadFolder.exists()) uploadFolder.mkdirs(); //이클립스가 파일 하나도 없으면 폴더 안만들어주기도 함. 그래서 이렇게 강제적으로 만들어주는거임
	}
	
	@GetMapping
	public ModelAndView get() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("file/fileForm");
		return mav;
	}
	
	
	public String post(@RequestParam(required=false) String uploader, HttpServletRequest req) throws IllegalStateException, IOException {
		if(req instanceof MultipartHttpServletRequest) {
			FileUploadVO fileVO = new FileUploadVO();
			fileVO.setUploader(uploader);
			MultipartFile uploadFile = ((MultipartHttpServletRequest) req).getFile("uploadFile");
			fileVO.setUploadFile(uploadFile);
			System.out.println("업로더 : " + uploader);
			String savename = UUID.randomUUID().toString();
			File saveFile = new File(uploadFolder, savename);
			uploadFile.transferTo(saveFile);
			String filename = uploadFile.getOriginalFilename();
			System.out.printf("%s를 %s로 메타데이터 저장 .\n", filename, savename);
		}
		return "redirect:/fileUpload";
	}	
	
	@PostMapping
	public String post(
				@Validated(InsertGroup.class) @ModelAttribute("fileVO") FileUploadVO fileVO, Errors errors, 
				Model model
			) throws IllegalStateException, IOException {
		boolean valid = !errors.hasErrors();
		if(valid) {
			System.out.println("업로더 : " + fileVO.getUploader());
			String savename = UUID.randomUUID().toString();
			File saveFile = new File(uploadFolder, savename);
			MultipartFile uploadFile = fileVO.getUploadFile();
			uploadFile.transferTo(saveFile);
			String filename = uploadFile.getOriginalFilename();
			System.out.printf("%s를 %s로 메타데이터 저장 .\n", filename, savename);
			return "redirect:/fileUpload";			
		}else {
			model.addAttribute("message", "검증 실패");
			return "file/fileForm";
		}
	}
	
	public String post(@RequestParam(required=false) String uploader, 
			@RequestPart(required=true) MultipartFile uploadFile
			) throws IllegalStateException, IOException {
		System.out.println("업로더 : " + uploader);
		String savename = UUID.randomUUID().toString();
		File saveFile = new File(uploadFolder, savename);		
		uploadFile.transferTo(saveFile);
		String filename = uploadFile.getOriginalFilename();
		System.out.printf("%s를 %s로 메타데이터 저장 .\n", filename, savename);
		return "redirect:/fileUpload";
	}
}
