package kr.or.ddit.board.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.or.ddit.board.dao.BoardDAOImpl;
import kr.or.ddit.board.dao.IBoardDAO;
import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.mvc.annotation.CommandHandler;
import kr.or.ddit.mvc.annotation.URIMapping;
import kr.or.ddit.mvc.annotation.resolvers.ModelData;
import kr.or.ddit.mvc.annotation.resolvers.RequestParameter;
import kr.or.ddit.vo.BoardVO;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.ProdVO;

@CommandHandler
public class BoardReadController {
	IBoardService service = new BoardServiceImpl();
	IBoardDAO dao = new BoardDAOImpl();
	
	@URIMapping("/board/boardList.do")
	public String list(
			@RequestParameter(name="page", required=false, defaultValue="1") int currentPage,
			HttpServletRequest req, HttpServletResponse resp
		) throws IOException{
		PagingVO<BoardVO> pagingVO = new PagingVO<>();
		int totalRecord = service.readBoardCount(pagingVO);
		pagingVO.setTotalRecord(totalRecord); // totalPage
		pagingVO.setCurrentPage(currentPage); // startRow, endRow, startPage, endPage
		
		List<BoardVO> boardList = service.readBoardList(pagingVO);
		pagingVO.setData(boardList);
		
		String accept = req.getHeader("Accept");
		String goPage = null;
		if(StringUtils.containsIgnoreCase(accept, "json")) {
			resp.setContentType("application/json;charset=UTF-8");
			ObjectMapper mapper = new ObjectMapper();
			try(
					PrintWriter out = resp.getWriter();	
					){
				mapper.writeValue(out, pagingVO);
			}
		}else {
			req.setAttribute("pagingVO", pagingVO);
			goPage = "board/boardList";
		}
		return goPage;
		
	}
	
	@URIMapping("/board/boardView.do")
	public String view(@RequestParameter(name="what") String what, 
			HttpServletRequest req) throws ServletException, IOException {
		int hit = dao.incrementHit(what);	
		BoardVO board = service.readBoard(what);
		req.setAttribute("board", board);
		return "board/boardView";
	}
}
