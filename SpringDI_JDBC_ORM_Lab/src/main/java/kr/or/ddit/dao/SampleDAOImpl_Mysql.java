package kr.or.ddit.dao;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public class SampleDAOImpl_Mysql implements ISampleDAO {

	public SampleDAOImpl_Mysql() {
		System.out.println(this.getClass().getSimpleName() + "객체 생성");
	}
	
	@PostConstruct
	public void init() {
		System.out.println(getClass() + " 객체 초기화");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println(getClass() + " 객체 소멸");
	}
	
	@Override
	public String selectOneData(String pk) {
		return pk + "로 Mysql에서 조회된 데이터";
	}

}
