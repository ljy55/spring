package kr.or.ddit.board.service;

import java.util.List;

import kr.or.ddit.vo.BoardVO;
import kr.or.ddit.vo.PagingVO;

public interface IBoardService {
	public int readBoardCount(PagingVO<BoardVO> pagingVO);
	public List<BoardVO> readBoardList(PagingVO<BoardVO> pagingVO);
	public BoardVO readBoard(String bo_no);
}
