package kr.or.ddit.member.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.commons.dao.IZipCodeSearchDAO;
import kr.or.ddit.commons.dao.ZipCodeSearchDAOImpl;
import kr.or.ddit.vo.ZipCodeVO;

public class ZipDAOImplTest {
	
	IZipCodeSearchDAO dao;
	@Before
	public void setUp() throws Exception {
		dao = ZipCodeSearchDAOImpl.getInstance();
	}

	@Test
	public void testSearchZip() {
		List<ZipCodeVO> zipList = dao.selectZipcodeList("대흥동");
		assertNotNull(zipList);
		assertNotEquals(0, zipList.size());
		System.out.println(zipList);
	}

}
