package kr.or.ddit.view;

import javax.inject.Inject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import kr.or.ddit.dao.ISampleDAO;
import kr.or.ddit.dao.SampleDAOImpl;
import kr.or.ddit.dao.SampleDAOImpl_Mysql;
import kr.or.ddit.service.ISampleService;
import kr.or.ddit.service.SampleServiceImpl;

@Controller
public class SampleView {
	public SampleView() {
		System.out.println(this.getClass().getSimpleName() + "객체 생성");
	}
	
	ISampleService service;
	
	@Inject
	public void setService(ISampleService service) {
		this.service = service;
	}
	
	public void display() {
		StringBuffer information = service.readData("A001");
		System.out.println(information);
	}
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("/kr/or/ddit/conf/Sample_Auto-Context.xml");
//		ISampleDAO dao = context.getBean(ISampleDAO.class);
//		System.out.println(dao.toString());
//		ISampleService service = context.getBean(ISampleService.class);
//		System.out.println(service.toString());
		SampleView view = context.getBean(SampleView.class);
		System.out.println(view);
		view.display();
	}
}
