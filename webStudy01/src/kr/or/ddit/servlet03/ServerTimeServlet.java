package kr.or.ddit.servlet03;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.servlet01.CalculateServlet.MarshallingType;

@WebServlet("/getServerTime.do")
public class ServerTimeServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		req.setCharacterEncoding("UTF-8");
//		resp.setContentType("application/json;charset=UTF-8");
//		String pattern = "{\"%s\":\"%tc\"}";
//		Calendar calender = Calendar.getInstance();
//		PrintWriter out = resp.getWriter();
//		out.println(String.format(pattern, "now", calender));
		
		Calendar calender = Calendar.getInstance();
		Map<String, Object> targetMap = new LinkedHashMap<>();
		targetMap.put("now", String.format("%tc", calender));
		String jsonText = MarshallingType.JSON.marshalling(targetMap);
		resp.setContentType(MarshallingType.JSON.getMime());
		try (
				PrintWriter out = resp.getWriter();
		){
			out.println(jsonText);
			
		}
		
		
		
	}
}
