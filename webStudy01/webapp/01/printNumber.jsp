<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
1. 브라우저에 1~10까지의 숫자 출력
<br><br>
<%
	for(int i = 1; i <= 10; i++){
		%>
		<%=i %>
		<% 
	}
%>
</body>
</html>