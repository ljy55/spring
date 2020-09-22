package kr.or.ddit.prod.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.db.CustomSqlSessionFactoryBuilder;
import kr.or.ddit.vo.ProdVO;

public class ProdDAOImpl implements IProdDAO {
	private static ProdDAOImpl self;
	
	public ProdDAOImpl() {
		super();
	}
	
	public static ProdDAOImpl getInstance() {
		if(self==null) 
			self = new ProdDAOImpl();
		return self;
	}
	
	private SqlSessionFactory sqlSessionFactory = CustomSqlSessionFactoryBuilder.getSqlSessionFactory();
	
	@Override
	public int insertProd(ProdVO prod) {
		try(
			SqlSession session = sqlSessionFactory.openSession(true);
		){
			IProdDAO mapper = session.getMapper(IProdDAO.class);
			return mapper.insertProd(prod);
		}
		
	}
	
	@Override
	public ProdVO selectProd(String prod_id) {
		try(
			SqlSession session = sqlSessionFactory.openSession();	
		){
			IProdDAO mapper = session.getMapper(IProdDAO.class);
			return mapper.selectProd(prod_id);
		}
	}

}
