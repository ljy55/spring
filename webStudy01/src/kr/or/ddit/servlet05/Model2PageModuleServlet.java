package kr.or.ddit.servlet05;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import kr.or.ddit.vo.MenuVO;


@WebServlet("/index.do")
public class Model2PageModuleServlet extends HttpServlet {
	public static enum ServiceType{
		CALULATE(
				MenuVO.getBuilder().menuId("CALULATE")
				.menuText("사칙연산자")
				.menuURI("/")
				.jspPath("/01/calForm.html")
				.build()),
		SESSIONTIMER(
				MenuVO.getBuilder().menuId("SESSIONTIMER")
				.menuText("세션타이머")
				.menuURI("/")
				.jspPath("/07/sessionTimer.jsp")
				.build()),
		EXPLORER(
				MenuVO.getBuilder().menuId("EXPLORER")
				.menuText("서버탐색기")
				.menuURI("/serverExplorer.do")
				.jspPath("/WEB-INF/views/serverExplorer.jsp")
				.build()),
		CALENDER(
				MenuVO.getBuilder().menuId("CALENDER")
				.menuText("달력")
				.menuURI("/")
				.jspPath("/07/calendar.jsp")
				.build()),
		STREAMING(
				MenuVO.getBuilder().menuId("STREAMING")
				.menuText("이미지뷰어")
				.menuURI("/image/imageList.do")
				.build());
		//new MenuVO("CALENDER", "달력", "/model2/laoutPage.do", "/07/calendar.jsp") 위에 builder코드로 바꾼거 VO로 작성하면 이렇게..
		private MenuVO menuVO;

		private ServiceType(MenuVO menuVO) {
			this.menuVO = menuVO;
		}
		
		public MenuVO getMenuVO() {
			return menuVO;
		}
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String serviceParam = req.getParameter("service");
		int sc = 200;
		String includePage = "/WEB-INF/views/index.jsp";
		if(StringUtils.isNotBlank(serviceParam)) {
			try {
				ServiceType serviceType = ServiceType.valueOf(serviceParam);
				
				MenuVO menu = serviceType.getMenuVO();
				
				includePage = menu.getJspPath();
			}catch (IllegalArgumentException e) {
				sc = 404;
			}
		}
		req.setAttribute("includePage", includePage);
		if(sc == 200) {
			req.getRequestDispatcher("/WEB-INF/views/layout.jsp").forward(req, resp);
		}else{
			resp.sendError(404, "제공하지 않는 서비스");
		}
		
	}
}
