package kr.or.ddit.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.db.CustomSqlSessionFactoryBuilder;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.ReplyVO;

public class ReplyDAOImpl implements IReplyDAO{
	private SqlSessionFactory sqlSessionFactory = 
			CustomSqlSessionFactoryBuilder.getSqlSessionFactory();
	
	@Override
	public int selectReplyCount(PagingVO<ReplyVO> pagingVO) {
		try(
				SqlSession session = sqlSessionFactory.openSession();
			){		
				IReplyDAO mapper = session.getMapper(IReplyDAO.class);
				return mapper.selectReplyCount(pagingVO);
			}
	}

	@Override
	public List<ReplyVO> selectReplyList(PagingVO<ReplyVO> pagingVO) {
		try(
				SqlSession session = sqlSessionFactory.openSession();
			){		
				IReplyDAO mapper = session.getMapper(IReplyDAO.class);
				return mapper.selectReplyList(pagingVO);
			}
	}

}
