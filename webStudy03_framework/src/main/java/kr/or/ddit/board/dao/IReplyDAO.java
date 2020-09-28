package kr.or.ddit.board.dao;

import java.util.List;

import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.ReplyVO;

public interface IReplyDAO {
	public int selectReplyCount(PagingVO<ReplyVO> pagingVO); 
	public List<ReplyVO> selectReplyList(PagingVO<ReplyVO> pagingVO);
}
