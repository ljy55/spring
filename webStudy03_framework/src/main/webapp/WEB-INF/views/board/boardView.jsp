<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardView</title>
<jsp:include page="/includee/preScript.jsp" />
</head>
<body>
	<table class="table table-bordered">
		<tr>
			<td>제목 : ${board.bo_title }</td>
			<td>작성자 : ${board.bo_writer }</td>
			<td>ip : ${board.bo_ip }</td>
		</tr>
		<tr>
			<td>첨부파일 : 없음</td>
			<td>작성일 : ${board.bo_date }</td>
			<td>조회수 : ${board.bo_hit }</td>
		</tr>
	</table>
		<div style="margin-left: 10px;">${board.bo_content }</div>
		<hr>
	<input type="button" value="수정하기" class="btn btn-primary" style="float: right;"
	onclick="location.href='${pageContext.request.contextPath }/board/boardList.do';"/>
	<input type="button" value="목록으로" class="btn btn-primary" style="float: right; "
		onclick="location.href='${pageContext.request.contextPath }/board/boardList.do';"/>
	<div style="margin-left: 10px;"><p>*댓글 작성*</p>
		<textarea rows="2" cols="150"></textarea>
		<input type="button" value="등록"/>
	</div>
	<form id="replyForm" action="${pageContext.request.contextPath }/board/boardView.do">	
		<table class="table table-bordered" id="replyTable">
			<tfoot>
			<tr>
				<td colspan="6" id="pagingArea">
					${pagingVO.pagingHTML_BS }
				</td>
			</tr>
		</tfoot>					
		</table>
		<input type="hidden" name="page" />
	</form>	
</body>
<script type="text/javascript">
let listTable = $("#replyTable");
let pagingArea = $("#pagingArea");
let pagingA = pagingArea.on('click', "a" ,function(){
	let page = $(this).data("page");
	console.log(page);
	searchForm.find("[name='page']").val(page);
	searchForm.submit();
	searchForm.find("[name='page']").val(1);
	return false;
});
let searchForm = $("#replyForm").on("submit", function(event){
	event.preventDefault();
	let url = this.action?this.action:location.href;
	let method = this.method?this.method:"get";
	let data = $(this).serialize(); // query string 
	$.ajax({
		url : url,
		method : method,
		data : data,
		dataType : "json",
		success : function(resp) {
			listTable.find("tbody").empty();
			pagingArea.empty();
			let list = resp.data;
			let trTags = [];
			if(list.length>0){
				$(list).each(function(idx, board){
					trTags.push(
						$("<tr>").append(
								$("<td>").text(board.rep_content)
						)
					);
					
				});
			}else{
				trTags.push($("<tr>").html($("<td colspan='6'>").text("댓글 없음.")));
			}
			listTable.find("tbody").html(trTags);
			pagingArea.html( resp.pagingHTML_BS );
		},
		error : function(errResp) {
		}
	});
	return false;
});
</script>
</html>