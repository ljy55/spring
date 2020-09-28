package kr.or.ddit.board.service;

import java.util.List;

import kr.or.ddit.board.dao.IReplyDAO;
import kr.or.ddit.board.dao.ReplyDAOImpl;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.ReplyVO;

public class ReplyServiceImpl implements IReplyService {
	
	IReplyDAO dao = new ReplyDAOImpl();

	@Override
	public int readReplyCount(PagingVO<ReplyVO> pagingVO) {
		return dao.selectReplyCount(pagingVO);
	}

	@Override
	public List<ReplyVO> readReplyList(PagingVO<ReplyVO> pagingVO) {
		return dao.selectReplyList(pagingVO);
	}

}
