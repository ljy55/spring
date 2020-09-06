<%@page import="org.apache.commons.lang3.StringUtils"%>
<%@page import="java.nio.file.Paths"%>
<%@page import="java.nio.file.Path"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String param = request.getParameter("uri");
	if(StringUtils.isBlank(param)) {
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src = "<%=request.getContextPath() %>/js/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		
		$("ul").on("click", "li", function(event) {
			event.stopPropagation();
			let li = $(this);
			
			if(li.attr("class") == "dir"){
				let child = li.find("ul").get(0);
				if(child){
					let vis = $(child).is(":visible");
					if(vis){
						$(child).hide();
					}else{
						$(child).show();
					}
				}else{
					let data = $(this).attr("id");
					console.log(li);
					$.ajax({
						url : "serverExplorer.do",
						data : {uri : data},
						dataType : "html",
						success : function(resp) {
							li.append(resp);
						},
						error : function(errResp) {
		
						}
					});
				}
				
			}
			
			
		})
		
		
	})

</script>
</head>
<body>
<h4>Model2 구조로 webStudy01 컨텍스트의 익스플로러 구현</h4>
<!-- ** 현재 컨텍스트에 있는 리소스들을 대상으로 한 익스플로러 구현 -->
<!-- 1. 파라미터가 없는 경우, 컨텍스트 루트의 모든 자식 리소스를 목록으로 제공함. -->
<!-- 2. 이후 모든 처리는 이클립스의 project explorer 뷰를 참고하여, 구현함. -->
<%
} 
%>
<ul>
<%
	
	File[] listFiles = (File[]) request.getAttribute("listFiles");
	String pattern = "<li class = '%s' id = '%s'>%s</li>";
	String contextRealPath = application.getRealPath("/");
	
	for(File file : listFiles){
		String fileName = file.getName();
		String clz = file.isDirectory()?"dir":"file";
		String abPath = file.getAbsolutePath();
		String tmp = StringUtils.remove(abPath, contextRealPath);
		String fileURI =tmp.replace(File.separatorChar, '/');
		fileURI = fileURI.startsWith("/")?fileURI:"/"+fileURI;
		
		out.println(String.format(pattern, clz, fileURI, fileName));
	}
	
%>
</ul>
<%if(StringUtils.isBlank(param)) { %>
<%-- 	<li class="<%=clz %>" id="/01"><%=file.getName() %></li> --%>
</body>
</html>
<% } %>