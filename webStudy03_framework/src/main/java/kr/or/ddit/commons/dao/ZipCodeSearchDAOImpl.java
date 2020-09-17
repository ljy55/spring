package kr.or.ddit.commons.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.db.ConnectionFactory;
import kr.or.ddit.db.CustomSqlSessionFactoryBuilder;
import kr.or.ddit.vo.ZipCodeVO;

public class ZipCodeSearchDAOImpl implements IZipCodeSearchDAO {
	
	private static ZipCodeSearchDAOImpl self;
	
	private ZipCodeSearchDAOImpl() {
		super();
	}
	
	private SqlSessionFactory sqlSessionFactory = CustomSqlSessionFactoryBuilder.getSqlSessionFactory();
	
	public static ZipCodeSearchDAOImpl getInstance() {
		if(self==null) self = new ZipCodeSearchDAOImpl();
		return self;
	}

	@Override
	public List<ZipCodeVO> selectZipcodeList(String keyword) {
		try (SqlSession session = sqlSessionFactory.openSession();) {

			IZipCodeSearchDAO mapper = session.getMapper(IZipCodeSearchDAO.class);
			return mapper.selectZipcodeList(keyword);
			
		}
	}

}
