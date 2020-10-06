package kr.or.ddit.dao;

import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public class SampleDAOImpl implements ISampleDAO {

	public SampleDAOImpl() {
		System.out.println(this.getClass().getSimpleName() + "객체 생성");
	}
	
	@Override
	public String selectOneData(String pk) {
		return pk + "로 오라클 DB에서 조회된 레코드";
	}

}
