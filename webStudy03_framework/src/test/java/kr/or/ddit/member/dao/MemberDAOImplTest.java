package kr.or.ddit.member.dao;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.vo.MemberVO;

public class MemberDAOImplTest {
	IMemberDAO dao;
	@Before
	public void setUp() throws Exception {
		dao = MemberDAOImpl.getInstance();
	}

	@Test
	public void testInsertMember() {
		MemberVO vo = new MemberVO();
		vo.setMem_id("dhfghf");
		vo.setMem_name("bb");
		vo.setMem_pass("1234");
		vo.setMem_add1("대전");
		vo.setMem_add2("중구");
		vo.setMem_hometel("010");
		vo.setMem_comtel("123");
		vo.setMem_mail("123");
		vo.setMem_regno1("123");
		vo.setMem_regno2("123");
		vo.setMem_zip("132");
		int a = dao.insertMember(vo);
		assertNotEquals(0, a);
		System.out.println(a);
		
	}

	@Test
	public void testSelectMemberList() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectMember() {
		MemberVO member = dao.selectMember("a001");
		assertNotNull(member);
		member = dao.selectMember("dfsdgfdgw");
		assertNull(member);
	}

	@Test
	public void testUpdateMember() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteMember() {
		fail("Not yet implemented");
	}

}
