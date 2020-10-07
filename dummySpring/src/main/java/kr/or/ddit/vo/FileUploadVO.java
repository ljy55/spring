package kr.or.ddit.vo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.DeleteGroup;
import lombok.Data;

@Data
public class FileUploadVO {
	@NotBlank(groups=DeleteGroup.class)
	private String uploader;
	@NotNull
	private MultipartFile uploadFile;
	
	public void setUploadFile(MultipartFile uploadFile) {
		String filename = uploadFile.getOriginalFilename();
		if(filename==null || filename.isEmpty()) {
			return;
		}
		
		this.uploadFile = uploadFile;			

	}
}
