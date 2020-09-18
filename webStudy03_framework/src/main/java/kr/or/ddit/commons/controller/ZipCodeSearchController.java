package kr.or.ddit.commons.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.or.ddit.commons.dao.IZipCodeSearchDAO;
import kr.or.ddit.commons.dao.ZipCodeSearchDAOImpl;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.ZipCodeVO;

@WebServlet("/zipSearch.do")
public class ZipCodeSearchController extends HttpServlet{
	IZipCodeSearchDAO searchDAO = ZipCodeSearchDAOImpl.getInstance();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String keyword = req.getParameter("keyword");
		PagingVO pagingVO = new PagingVO();
		List<ZipCodeVO> zipCodeList = searchDAO.selectZipcodeList(pagingVO); //나중에 keyword로 고치기
		resp.setContentType("application/json;charset=UTF-8");
		ObjectMapper mapper = new ObjectMapper();
		try(
			PrintWriter out = resp.getWriter();	
		){
			mapper.writeValue(out, zipCodeList);
		}
	}
}
