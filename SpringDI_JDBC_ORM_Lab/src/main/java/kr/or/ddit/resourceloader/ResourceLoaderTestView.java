package kr.or.ddit.resourceloader;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class ResourceLoaderTestView {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = 
				new GenericXmlApplicationContext("classpath:/kr/or/ddit/conf/resourceloader/Resource-Context.xml");
		TempFolderVO vo = context.getBean(TempFolderVO.class);
		System.out.println(vo);
	}
}
