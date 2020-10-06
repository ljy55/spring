package kr.or.ddit.dao;

public class DAOFactory {
	public ISampleDAO getSampleDAO() {
		return new SampleDAOImpl();
	}
}
