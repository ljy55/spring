package kr.or.ddit.board.service;

import java.util.List;

import kr.or.ddit.board.dao.BoardDAOImpl;
import kr.or.ddit.board.dao.IBoardDAO;
import kr.or.ddit.exception.CustomException;
import kr.or.ddit.vo.BoardVO;
import kr.or.ddit.vo.PagingVO;

public class BoardServiceImpl implements IBoardService {
	
	IBoardDAO dao = new BoardDAOImpl();

	@Override
	public int readBoardCount(PagingVO<BoardVO> pagingVO) {
		return dao.selectBoardCount(pagingVO);
	}

	@Override
	public List<BoardVO> readBoardList(PagingVO<BoardVO> pagingVO) {
		return dao.selectBoardList(pagingVO);
	}

	@Override
	public BoardVO readBoard(String bo_no) {
		BoardVO board = dao.selectBoard(bo_no);
		if(board==null) {
			throw new CustomException(bo_no + "게시물은 존재하지 않음");
		}
		return board;
	}

}
