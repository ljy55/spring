<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
2. 브라우저에 !10 연산의 결과를 !10=?? 와 같은 형식으로 출력
<br><br>
<%
	int result = 1;
	for(int i = 1; i <= 10; i++){
		result = result * i;
	}
	%>
	<%=String.format("!10 = %s", result) %>
	<%
%>

</body>
</html>