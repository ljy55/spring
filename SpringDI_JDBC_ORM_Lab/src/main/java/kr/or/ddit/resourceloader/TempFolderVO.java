package kr.or.ddit.resourceloader;

import java.io.File;
import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;

public class TempFolderVO {
	@Value("#{appInfo.prodImage}")
	private String prodImage;
//	@Value("#{appInfo.prodImage}")
	private File prodImageFolder;
	@Value("#{appInfo['saveFolder']}")
	private String saveFolder;
//	@Value("#{appInfo['saveFolder']}")
	private File saveFolderFolder;
	
	@Inject
	ApplicationContext context;

	@PostConstruct
	public void init() throws IOException {
		System.err.println(prodImage);
		System.err.println(saveFolder);
		Resource res = context.getResource(prodImage);
		if(res.exists()) {
			prodImageFolder = res.getFile();			
		}
//		if(!prodImageFolder.exists()) prodImageFolder.mkdirs();
		saveFolderFolder = context.getResource(saveFolder).getFile();		
	}
	
	public void setProdImage(String prodImage) {
		this.prodImage = prodImage;
	}
	
	public void setSaveFolder(String saveFolder) {
		this.saveFolder = saveFolder;
	}

	@Override
	public String toString() {
		return "TempFolderVO [prodImage=" + prodImage + ",\n prodImageFolder=" + prodImageFolder + ",\n saveFolder="
				+ saveFolder + ",\n saveFolderFolder=" + saveFolderFolder + "]";
	}

	
	
	
}
