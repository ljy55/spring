<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
4. 2~9단을 구구단을 출력, 승수는 1~9까지
<br><br>
<table border="1">
<%
	for(int i = 2; i <= 9; i++){
		%>
		<tr>
		<%
		for(int j = 1; j <= 9; j++){
			%>
			<td>
			<%=String.format("%s * %d = %s", i,j,i*j) %>
			</td>
			<%
		}
		%>
		</tr>
		<%
	}
%>

</table>

</body>
</html>