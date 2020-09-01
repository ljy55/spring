<%@page import="org.apache.commons.lang3.StringUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	private long factorial(int num, StringBuffer expr){
		if(num <= 0){
			throw new IllegalArgumentException("음수는 연산 불가");
		}else if(num == 1){
			expr.append(num);
			return num;
		}else{
			expr.append(num + "*");
			return num * factorial(num-1, expr) ;
			
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
3. 재귀호출 구조를 이용하여 2번(!10)을 다시 처리<br>
!10 = 10 * 9 * * * 1...
<br><br>
<%-- <%
int num = 10;
StringBuffer expr = new StringBuffer();
long result = factorial(num, expr);
%>
<%=String.format("!%d = %s = %d", num, expr, result) %> --%>

<%-- <%
try{
}catch(IllegalArgumentException e){
	e.printStackTrace();
	%>
	예외는 발생했지만 정상인것처럼...
	<%
}
%> --%>
<%
   int num = 10;
   String numStr = request.getParameter("op");
   
   if(StringUtils.isNumeric(numStr)){
      num = Integer.parseInt(numStr);
   }
   
   StringBuffer expr = new StringBuffer();
   long result = factorial(num, expr);
%>
<%= String.format("!%d = %s = %d", num, expr, result) %>

<form>
	<input type="number" name="op"/>
	<button type="submit">전송</button>
	
</form>

</body>
</html>