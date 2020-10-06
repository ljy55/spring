package kr.or.ddit.service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import kr.or.ddit.dao.DAOFactory;
import kr.or.ddit.dao.ISampleDAO;
import kr.or.ddit.dao.SampleDAOImpl;
import kr.or.ddit.dao.SampleDAOImpl_Mysql;

@Service
public class SampleServiceImpl implements ISampleService {
	
	ApplicationContext context;
	
	@Inject
	public void setContext(ApplicationContext context) {
		this.context = context;
	}
	
	@PostConstruct
	public void init() {
		System.out.println(context.toString());
		
	}
	
	// 1. 의존 관계를 형성할때 new 키워드 직접 사용. 결합력 최상
//	ISampleDAO dao = new SampleDAOImpl();
//	ISampleDAO dao = new SampleDAOImpl_Mysql();
	
	// 2. Factory Object Pattern : factory 객체와의 결합력 잔존.
//	ISampleDAO dao = new DAOFactory().getSampleDAO();
	
	// 3. DI 구조를 바탕으로 한 Strategy Pattern(전략 주입자 필요) : 전략의 주입자가 모든 결합력을 떠안음.
	
	// 4. DI Container(전략 주입자) 구조 사용.
	@Resource(name="sampleDAOImpl")
	private ISampleDAO dao;
	
	public void setDao(ISampleDAO dao) {
		this.dao = dao;
	}
	
//	public SampleServiceImpl() {
//		System.out.println(this.getClass().getSimpleName() + "객체 생성-기본 생성자");
//	}
	
	
	public SampleServiceImpl(@Autowired @Qualifier("sampleDAOImpl")ISampleDAO dao) {
		super();
		this.dao = dao;
		System.out.println(this.getClass().getSimpleName() + "객체 생성-아규먼트 있는 생성자");
	}



	@Override
	public StringBuffer readData(String pk) {
		String rawData = dao.selectOneData(pk);
		return new StringBuffer(rawData + "를 가공함");
	}

}
