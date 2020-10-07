package kr.or.ddit.resourceloader;

import java.io.File;
import java.io.IOException;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

public class SpringResourceLoaderDesc {
	public static void main(String[] args) throws IOException {
		ConfigurableApplicationContext context =
				new ClassPathXmlApplicationContext();
//		1. class path resource
			ClassPathResource resource1 = new ClassPathResource("/log4j2.xml");
			File file1 = resource1.getFile();
			System.out.println(file1.exists());
			Resource resource2 = context.getResource("classpath:/log4j2.xml");
			File file2 = resource2.getFile();
			System.out.println(file1.equals(file2));
			System.out.println(resource2.getClass().getSimpleName());
//		2. file system resource
			FileSystemResource resource3 = new FileSystemResource("e:/contents/족2.png");
			Resource resource4 = context.getResource("file:e:/contents/족2.png");
			File file3 = resource3.getFile();
			File file4 = resource4.getFile();
			System.out.println(file3.equals(file4));
			System.out.println(resource4.getClass().getSimpleName());
//		3. web resource
			UrlResource resource5 = new UrlResource("https://spring.io/images/spring-logo-9146a4d3298760c2e7e49595184e1975.svg");
			Resource resource6 = context.getResource("https://spring.io/images/spring-logo-9146a4d3298760c2e7e49595184e1975.svg");
			System.out.println(resource6.getClass().getSimpleName());
			System.out.println(resource5.contentLength());
			
	}
}
