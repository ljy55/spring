<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>03/practice.jsp</title>
</head>
<style>
	pre{
		border: 1px solid black;
	}
</style>
<body>
<pre>
--- 연습 문제 ----
<a href="<%=request.getContextPath()%>/01/printNumber.jsp">
1. 브라우저에 1~10까지의 숫자 출력 : /01/printNumber.jsp</a>
<a href="<%=request.getContextPath()%>/02/factorial.jsp">
2. 브라우저에 !10 연산의 결과를 !10=?? 와 같은 형식으로 출력 : /02/factorial.jsp</a>
<a href="<%=request.getContextPath()%>/03/recursive.jsp">
3. 재귀호출 구조를 이용하여 2번을 다시 처리 : /03/recursive.jsp</a>
<a href="<%=request.getContextPath()%>/04/gugudan.jsp">
4. 2~9단을 구구단을 출력, 승수는 1~9까지. table 태그를 사용하여 2차원 행렬 형태로 출력 : /04/gugudan.jsp</a>
<a href="<%=request.getContextPath()%>/04/methodGugudan.jsp?minDan=4&maxDan=7">
5. 구구단의 곱하기 연산을 수행하는 메소드를 분리하여 처리. : /04/methodGugudan.jsp</a>
<a href="<%=request.getContextPath()%>/04/gugudanForm.jsp">
6. /04/gugudanForm.jsp를 만들고, 클라이언트가 선택한 범위내(minDan~maxDan)의 구구단이 처리되도록.
</a>
</pre>
</body>
</html>