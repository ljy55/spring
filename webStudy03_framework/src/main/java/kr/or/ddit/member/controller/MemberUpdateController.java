package kr.or.ddit.member.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.vo.MemberVO;

@WebServlet("/myDataUpdate.do")
public class MemberUpdateController extends HttpServlet {
	private IMemberService service = MemberServiceImpl.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1. 요청 파라미터 획득
		//req.setCharacterEncoding("UTF-8"); //한글처리를 위한 인코딩
		//MemberVO authMember = (MemberVO) req.getSession().getAttribute("authMember");
		//MemberVO member = service.retrieveMember(authMember.getMem_id());
		//req.setAttribute("person", member);	
		req.setCharacterEncoding("UTF-8"); //한글처리를 위한 인코딩
		MemberVO member = new MemberVO();
		req.setAttribute("person", member);
		//member.setMem_id(req.getParameter("mem_id"));
		Map<String, String[]> parameterMap = req.getParameterMap();
		try {
			BeanUtils.populate(member, parameterMap);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		System.out.println(member);
		
		ServiceResult result = service.modifyMember(member);
		
		resp.sendRedirect(req.getContextPath() + "/");
		
	}
	
	/*@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberVO member = new MemberVO();
		req.setAttribute("member", member);
		//member.setMem_id(req.getParameter("mem_id"));
		Map<String, String[]> parameterMap = req.getParameterMap();
		try {
			BeanUtils.populate(member, parameterMap);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		System.out.println(member);
		
		ServiceResult result = service.modifyMember(member);
		
		resp.sendRedirect(req.getContextPath() + "/index.jsp");
		
	}*/
}
