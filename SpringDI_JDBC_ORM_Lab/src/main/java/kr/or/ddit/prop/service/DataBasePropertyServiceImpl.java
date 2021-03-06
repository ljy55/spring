package kr.or.ddit.prop.service;

import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import kr.or.ddit.prop.dao.IDataBasePropertyDAO;
import kr.or.ddit.vo.DataBasePropertyVO;

public class DataBasePropertyServiceImpl implements IDataBasePropertyService {
	// 결합력 최상!!, HCLC(High Cohesion, Loose Coupling)
//	IDataBasePropertyDAO dao = new DataBasePropertyDAO_JDBC();
//	IDataBasePropertyDAO dao = DataBasePropertyDAO_Mybatis.getInstance();
	private IDataBasePropertyDAO dao;
	
	@Inject
	public DataBasePropertyServiceImpl(IDataBasePropertyDAO dao) {
		super();
		this.dao = dao;
		System.out.println(dao.toString());
	}

	@Override
	public List<DataBasePropertyVO> readDataBaseProperties(DataBasePropertyVO param) {
		List<DataBasePropertyVO> list = dao.selectDataBaseProperties(param);
		Calendar cal = Calendar.getInstance();
		String ptrn = "%s[%tc]";
		for(DataBasePropertyVO vo : list) {
			vo.setProperty_name(String.format(ptrn, vo.getProperty_name(), cal));
		}
		return list;
	}
	
	@Override
	public List<String> readAllProperty_names() {
		return dao.selectAllProperty_names();
	}

}













