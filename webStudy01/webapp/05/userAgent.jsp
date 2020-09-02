<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%! 
private enum Browser{
	chrome("크롬"), firefox("파이어폭스"), explorer("익스플로러");
	
	private String name;
	
	private Browser(String name){
		this.name = name;
	}
	
	public String pattern(){
		return String.format("<h4>%s을 사용하고 있음.</h4>", name);
	}
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String userAgent = request.getHeader("User-Agent");
	Browser browser = null;
	if(userAgent.contains("Chrome")){
		browser = Browser.chrome;
	}else if(userAgent.contains("Firefox")){
		browser = Browser.firefox;
	}else if(userAgent.contains("rv:11.0")){
		browser = Browser.explorer;
	}else{
		out.println("알수없는 브라우저 입니다");
		return;
	}
	out.println(browser.pattern());
%>
</body>
</html>