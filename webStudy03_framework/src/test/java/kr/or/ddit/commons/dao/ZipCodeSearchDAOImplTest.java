package kr.or.ddit.commons.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.ZipCodeVO;

public class ZipCodeSearchDAOImplTest {

	IZipCodeSearchDAO dao;
	
	@Before
	public void setUp() throws Exception {
		dao = ZipCodeSearchDAOImpl.getInstance();
	}

	@Test
	public void testSelectZipcodeList() {
		List<ZipCodeVO> zipList = dao.selectZipcodeList(null);
		assertNotNull(zipList);
		assertNotEquals(0, zipList.size());
		System.out.println(zipList);
	}

}
















