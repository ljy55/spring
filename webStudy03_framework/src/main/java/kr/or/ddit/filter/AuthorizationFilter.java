package kr.or.ddit.filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.vo.MemberVO;

/**
 * 보호 자원에 대한 접근 권한 소유여부 확인
 *
 */
//@WebFilter("/*") : 이렇게 하면 web.xml에 등록안해도 저절로 매핑됨. 단, 문제는 필터의 순서를 정할 수 없다는 것.
public class AuthorizationFilter implements Filter {
	private static final Logger logger = LoggerFactory.getLogger(AuthenticationFilter.class);
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		logger.info("{} 객체 생성 및 초기화 완료.", getClass().getName());
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// authenticationFilter에 있는 secured맵 가져오기
		Map<String, String[]> secured = (Map<String, String[]>) request.getServletContext().getAttribute("secured");
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		String uri = req.getRequestURI();
		int length = req.getContextPath().length();
		uri = uri.substring(length).split(";")[0];
		
		boolean pass = true;
		if(secured.containsKey(uri)) {	//보호가 필요한 자원이다
			MemberVO authMember = (MemberVO) req.getSession().getAttribute("authMember");
			String userRole = authMember.getMem_role();
			String[] roles = secured.get(uri);
			if(Arrays.binarySearch(roles, userRole)<0) {
				pass = false;
			}
		}
		
		if(pass) {
			chain.doFilter(request, response);
		}else {
			resp.sendError(HttpServletResponse.SC_UNAUTHORIZED);
		}
		
	}

	@Override
	public void destroy() {
		logger.info("{} 객체 소멸.", getClass().getName());
		
	}
	
}
