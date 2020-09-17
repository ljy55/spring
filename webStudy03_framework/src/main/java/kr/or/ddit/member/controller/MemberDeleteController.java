package kr.or.ddit.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;

@WebServlet("/leaveApp.do")
public class MemberDeleteController extends HttpServlet {
	private IMemberService service = MemberServiceImpl.getInstance();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//요청 아이디 받기, jsp에 모달창에서 비밀번호 받기 
		//비밀번호 일치하는지 검증하기. 일치하지 않으면 오류 메시지 날려주고, 일치하면 delete 날려주기
		//삭제 완료되면 로그아웃시켜서 index로...
	}
}
