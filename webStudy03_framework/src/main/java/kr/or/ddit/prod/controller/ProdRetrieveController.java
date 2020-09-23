package kr.or.ddit.prod.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.or.ddit.mvc.annotation.CommandHandler;
import kr.or.ddit.mvc.annotation.HttpMethod;
import kr.or.ddit.mvc.annotation.URIMapping;
import kr.or.ddit.mvc.annotation.resolvers.ModelData;
import kr.or.ddit.mvc.annotation.resolvers.RequestParameter;
import kr.or.ddit.prod.dao.IOthersDAO;
import kr.or.ddit.prod.dao.OthersDAOImpl;
import kr.or.ddit.prod.service.IProdService;
import kr.or.ddit.prod.service.ProdServiceImpl;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.ProdVO;

@CommandHandler
public class ProdRetrieveController{
	IProdService service = new ProdServiceImpl();
	IOthersDAO othersDAO = new OthersDAOImpl();
	
	public void addAttribute(HttpServletRequest req){
		req.setAttribute("lprodList", othersDAO.selectLprodGuList());
		req.setAttribute("buyerList", othersDAO.selectBuyerList());
	}
	
	@URIMapping(value="/prod/prodView.do", method=HttpMethod.GET)
	public String prod(@RequestParameter(name="what", required=true) String what, HttpServletRequest req) throws ServletException, IOException {
		
		ProdVO prod = service.retrieveProd(what);
		req.setAttribute("prod", prod);
		String goPage = "prod/prodView";
		return goPage;
	}
	
	@URIMapping(value="/prod/prodList.do", method=HttpMethod.GET)
	public String list(
			@RequestParameter(name="page", required=false, defaultValue="1") int currentPage,
			@ModelData(name="searchDetail") ProdVO searchDetail,
			HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		====검색
		addAttribute(req);
		PagingVO<ProdVO> pagingVO = new PagingVO<>(10, 5);
		pagingVO.setSearchDetail(searchDetail);
//		========
		int totalRecord = service.retrieveProdCount(pagingVO);
		pagingVO.setTotalRecord(totalRecord); // totalPage
		pagingVO.setCurrentPage(currentPage); // startRow, endRow, startPage, endPage
		
		List<ProdVO> prodList = service.retrieveProdList(pagingVO);
		pagingVO.setData(prodList);
		
		String accept = req.getHeader("Accept");
		if(StringUtils.containsIgnoreCase(accept, "json")) {
			resp.setContentType("application/json;charset=UTF-8");
			ObjectMapper mapper = new ObjectMapper();
			try(
					PrintWriter out = resp.getWriter();	
					){
				mapper.writeValue(out, pagingVO);
			}
			return null;
		}else {
			req.setAttribute("pagingVO", pagingVO);
			String goPage = "prod/prodList";
			return goPage;
		}
	}
	
	@URIMapping("/prod/prodView.do")
	public String doGet(@RequestParameter(name="what") String what, HttpServletRequest req) throws ServletException, IOException {
		ProdVO prod = service.retrieveProd(what);
		req.setAttribute("prod", prod);
		return "prod/prodView";
	}
}











