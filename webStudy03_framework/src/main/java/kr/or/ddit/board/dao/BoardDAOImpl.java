package kr.or.ddit.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.db.CustomSqlSessionFactoryBuilder;
import kr.or.ddit.vo.BoardVO;
import kr.or.ddit.vo.PagingVO;

public class BoardDAOImpl implements IBoardDAO {
	private SqlSessionFactory sqlSessionFactory = 
			CustomSqlSessionFactoryBuilder.getSqlSessionFactory();

	@Override
	public int selectBoardCount(PagingVO<BoardVO> pagingVO) {
		try(
				SqlSession session = sqlSessionFactory.openSession();
			){		
				IBoardDAO mapper = session.getMapper(IBoardDAO.class);
				return mapper.selectBoardCount(pagingVO);
			}
	}

	@Override
	public List<BoardVO> selectBoardList(PagingVO<BoardVO> pagingVO) {
		try(
				SqlSession session = sqlSessionFactory.openSession();
			){		
				IBoardDAO mapper = session.getMapper(IBoardDAO.class);
				return mapper.selectBoardList(pagingVO);
			}
	}

	@Override
	public BoardVO selectBoard(String bo_no) {
		try(
				SqlSession session = sqlSessionFactory.openSession();
			){		
				IBoardDAO mapper = session.getMapper(IBoardDAO.class);
				return mapper.selectBoard(bo_no);
			}
	}
	
	@Override
	public int incrementHit(String bo_no) {
		try(
				SqlSession session = sqlSessionFactory.openSession(true);
			){		
				IBoardDAO mapper = session.getMapper(IBoardDAO.class);
				return mapper.incrementHit(bo_no);
			}
	}
	
	@Override
	public int insertBoard(BoardVO board) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int updateBoard(BoardVO board) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteBoard(String bo_no) {
		// TODO Auto-generated method stub
		return 0;
	}

	


}
