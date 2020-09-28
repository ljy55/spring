<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardList</title>
<jsp:include page="/includee/preScript.jsp" />
<style>
	#tHead{
		background-color: black;
		color: white;
		text-align: center;
	}
</style>
</head>
<body>
<form id="searchForm" action="${pageContext.request.contextPath }/board/boardList.do" class="form-inline">
	<input type="hidden" name="page" />
	<input type="text" name="board_name" class="form-control mr-3" />
	<input type="submit" class="btn btn-primary mr-3" value="검색" />
	<input type="button" class="btn btn-secondary" value="게시물 작성" />
</form>
	<table id="BoardTable" class="table table-bordered">
		<thead id="tHead">
			<tr>
				<th>게시글 번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>
		<c:set var="dataList" value="${pagingVO.data }" />
		<c:choose>
			<c:when test="${not empty dataList }">
				<c:forEach items="${dataList }" var="board">
					<tr>
						<td>
						<c:url value="/board/boardView.do" var="boardViewURL">
						<c:param name="what" value="${board.bo_no }"/>
						</c:url>
						${board.bo_no }
						</td>
						<td><a href="${boardViewURL }">${board.bo_title}</a></td>
						<td>${board.bo_writer }</td>
						<td>${board.bo_date }</td>
						<td>${board.bo_hit }</td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr>
					<td colspan="6">검색 조건에 맞는 게시글 없음.</td>
				</tr>
			</c:otherwise>
		</c:choose>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="6" id="pagingArea">
					${pagingVO.pagingHTML_BS }
				</td>
			</tr>
		</tfoot>
	</table>
</body>
<script type="text/javascript">
	let listTable = $("#BoardTable");
	let pagingArea = $("#pagingArea");
	let pagingA = pagingArea.on('click', "a" ,function(){
		let page = $(this).data("page");
		console.log(page);
		searchForm.find("[name='page']").val(page);
		searchForm.submit();
		searchForm.find("[name='page']").val(1);
		return false;
	});
	let searchForm = $("#searchForm").on("submit", function(event){
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
									$("<td>").text(board.bo_no),
									$("<td>").html(
											$("<a>").text(board.bo_title)
													.attr("href", "${pageContext.request.contextPath }/board/boardView.do?what="+board.board_no)
									),
								$("<td>").text(board.bo_writer),
								$("<td>").text(board.bo_date),
								$("<td>").text(board.bo_hit),
							)
						);
						
					});
				}else{
					trTags.push($("<tr>").html($("<td colspan='6'>").text("조건에 맞는 게시글 없음.")));
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