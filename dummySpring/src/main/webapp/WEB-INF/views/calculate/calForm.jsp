<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/res/js/jquery-3.5.1.min.js"></script>
<%-- <script type="text/javascript" src="${pageContext.request.contextPath }/res/js/jquery.Form.min.js"></script> --%>
<script type="text/javascript">
	$(function(){
		$("form:first").on("submit", function(event){
			event.preventDefault();
			let url = this.action?this.action:"";
			let method = this.method?this.method:"get";
			let data = $(this).serialize();
			$.ajax({
				url : url,
				data : data,
				method : method,
				dataType : "json", // Accept, Content-Type
				success : function(resp) {
					$("#resultArea").html(resp.result);
				},
				error : function(errResp) {
				}
			});
		});
	});
</script> 
</head>
<body>
<form method="post">
	<input type="number" name="leftOp" value="${calVO.leftOp }">
	+
	<input type="number" name="rightOp" value="${calVO.rightOp }">
	<input type="submit" value="=">
	<span id="resultArea">${calVO.result }</span>
</form>
</body>
</html>