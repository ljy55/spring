<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<ul>
	<li><a href="<%=request.getContextPath()%>/member/memberList.do">회원관리</a></li>
	<li><a href="<%=request.getContextPath()%>/prod/prodList.do">상품관리</a></li>
	<li><a href="#">거래처관리</a></li>
	<li><a href="#">게시판</a></li>
	<li><a href="#">방명록</a></li>
</ul>
<script>
	$.fn.test=function(){
		console.log("TTTTTT");
	}
</script>