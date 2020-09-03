package kr.or.ddit.servlet01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.enumpkg.OperatorType;

@WebServlet("/01/calculate.do")
public class CalculateServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String name = req.getParameter("name");
		System.out.println(name);
		
		//resp.setContentType("text/plain;charset=UTF-8"); //mime은 관행적으로 첫줄에 작성
		String accept = req.getHeader("Accept");
		
		String param1 = req.getParameter("leftOp");
		String param2 = req.getParameter("rightOp");
		String param3 = req.getParameter("operator");
		
		OperatorType type = null;
		boolean valid = true;
		if(param1 == null || !param1.matches("-?\\d+")) {
			valid = false;
		}
		if(param2 == null || !param2.matches("-?[0-9]{1,}")) {
			valid = false;
		}
		if(param3 == null) {
			valid = false;
		}else {
			try {
				type = OperatorType.valueOf(param3);
			}catch (IllegalArgumentException e) {
				valid = false;
			}
		}		
		
		Map<String, Object> targetMap = new LinkedHashMap<>();
		if(valid) {
			int leftOp = Integer.parseInt(param1);
			int rightOp = Integer.parseInt(param2);
			
			long result = type.operate(leftOp, rightOp);
			String expression = type.operateTo(leftOp, rightOp);
			targetMap.put("result", result);
			targetMap.put("expression", expression);
			
			
			/*
			 * switch (param3) { case "PLUS": result = leftOp + rightOp; break; case
			 * "MINUS": result = leftOp - rightOp; break; case "MULTIPLY": result = leftOp *
			 * rightOp; break; case "DIVDE": result = leftOp / rightOp; break;
			 * 
			 * default: break; }
			 */
			
			//out.println(result);
		}else {
			//요청 처리에 실패했음을 전송
			targetMap.put("message", "처리 실패");
		}
		
		String mime = "text/html;charset=UTF-8";
		MarshallingType marshallingType = null;
		if(accept.contains("json")) {
			//mime = "application/json;charset=UTF-8";
			marshallingType = MarshallingType.JSON;
		}else if(accept.contains("xml")) {
			//mime = "application/xml;charset=UTF-8";
			marshallingType = MarshallingType.XML;
			
		}
		
		resp.setContentType(marshallingType==null?mime:marshallingType.getMime());
		PrintWriter out = resp.getWriter();
		
		String respText = marshallingType.marshalling(targetMap);
		out.println(respText);
		out.close();
	}

	private interface Marshaller{
		public String marshalling(Map<String, Object> targetMap);
	}
	
	public static enum MarshallingType{
		JSON("application/json;charset=UTF-8",new Marshaller(){

			@Override
			public String marshalling(Map<String, Object> targetMap) {
				//"{\"tmp1\":\"test\", \"tmp2\":3, \"tmp3\":true}"
				StringBuffer jsonText = new StringBuffer("{");
				String pattern = "\"%s\":\"%s\",";
				for(Entry<String, Object> entry : targetMap.entrySet()) {
					jsonText.append(String.format(pattern, entry.getKey(), entry.getValue().toString()));
				}
				int idx = jsonText.lastIndexOf(",");
				jsonText.deleteCharAt(idx);
				jsonText.append("}");
				//mashalling native -> json,xml
				return jsonText.toString();
			}
			
		}), XML("application/xml;charset=UTF-8", (targetMap)->{
			String pattern = "<%1$s>%2$s</%1$s>";
			StringBuffer xmlText = new StringBuffer("<root>");
			for(Entry<String, Object> entry : targetMap.entrySet()) {
				xmlText.append(String.format(pattern, entry.getKey(), entry.getValue().toString()));
			}
			xmlText.append("</root>");
			return xmlText.toString();
		});
		private Marshaller marshaller;
		private String mime;

		private MarshallingType(String mime, Marshaller marshaller) {
			this.mime = mime;
			this.marshaller = marshaller;
		}
		public String getMime() {
			return mime;
		}
		
		public String marshalling(Map<String, Object> targetMap) {
			return marshaller.marshalling(targetMap);
		}
	
	}
}
