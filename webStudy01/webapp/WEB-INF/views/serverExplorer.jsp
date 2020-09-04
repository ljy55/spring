<%@page import="java.nio.file.Paths"%>
<%@page import="java.nio.file.Path"%>
<%@page import="java.util.List"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h4>Model2 구조로 webStudy01 컨텍스트의 익스플로러 구현</h4>
<%
	File[] listFiles = (File[])request.getAttribute("listFiles");
	for(int i = 0; i < listFiles.length; i++){
		String folderPath = listFiles[i].toString();
		//out.println();
	}
%>
<ul>
<%-- 	<li class="<%=clz %>" id="/01"><%=file.getName() %></li> --%>
</ul>
</body>
</html>