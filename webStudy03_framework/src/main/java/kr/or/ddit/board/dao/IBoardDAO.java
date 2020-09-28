package kr.or.ddit.board.dao;

import java.util.List;

import kr.or.ddit.vo.BoardVO;
import kr.or.ddit.vo.PagingVO;

/**
 * 게시판 Persistence Layer
 *
 */
public interface IBoardDAO {
	public int selectBoardCount(PagingVO<BoardVO> pagingVO);
	public List<BoardVO> selectBoardList(PagingVO<BoardVO> pagingVO);
	public BoardVO selectBoard(String bo_no);
	public int incrementHit(String bo_no);
	public int insertBoard(BoardVO board);  
	public int updateBoard(BoardVO board);
	public int deleteBoard(String bo_no);
}
