<%@page import="com.sun.org.apache.regexp.internal.REUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/calForm.js"></script>
<script type="text/javascript">
	$(function(){
		var resultArea = $("#resultArea");
		
		var minDanTag = $("[name='minDan']").on("change", function(){
			let minDan = $(this).val();
			let currentIndex = minDan-1;
			$("[name='maxDan']").find("option:gt(0)").hide();
			if(currentIndex<=1){
				$("[name='maxDan']").find("option").show();
			}else{
				$("[name='maxDan']").find("option:gt("+(currentIndex-1)+")").show();
			}
		});		
		var maxDanTag = $("[name='maxDan']");
		
		var form = $("form:nth(0)").convertForm({
			success:function(resp){
			resultArea.html(resp);
			resultArea.css({
				border:"1px solid red",
				backgroundColor:"yellow"
			}); //함수의 체인구조
		},
		validation:function(){			 
			 let minDan = minDanTag.val();
			 let maxDan = maxDanTag.val();
			 let valid = minDan <= maxDan;
			 if(!valid){
				 $("form").after("<h4 class='errors'>입력 데이터에 문제 있음.</h4>");
			 }
			 return valid;
		 },
		 init:function(){
			 $("h4.errors").remove();
			 resultArea.empty();
		 }
	});	
		
	});	
</script>
</head>
<body>
구구단의 범위를 입력받음 -> 서버로 넘겨서(method gugudan jsp) -> 다시 클라이언트에게 가져다줌
<form action="<%=request.getContextPath() %>/04/methodGugudan.jsp" method="post">
	<select name="minDan">
		<option value>단</option>
		<%
			String pattern = "<option value='%1$d'>%1$d단</option>";
			for(int dan = 2; dan <= 9; dan++)
				out.println(String.format(pattern, dan));			
		%>
	</select>
	<select name="maxDan">
		<option value>단</option>
		<%
			for(int dan = 2; dan <= 9; dan++)
				out.println(String.format(pattern, dan));
		%>
	</select>
	<button type="submit">전송</button>
</form>
<div id="resultArea">

</div>
</body>
</html>