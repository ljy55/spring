package kr.or.ddit.prod.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.ProdVO;

/**
 * 상품관리 Persistence Layer
 *
 */
public interface IProdDAO {
	public int insertProd(ProdVO prod, SqlSession session);
	public ProdVO selectProd(String prod_id);
	public int selectProdCount(PagingVO<ProdVO> pagingVO);
//	검색 조건: 분류, 거래처, 상품명
	public List<ProdVO> selectProdList(PagingVO<ProdVO> pagingVO);
	
	public int updateProd(ProdVO prod, SqlSession session);
}
