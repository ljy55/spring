<%@page import="kr.or.ddit.vo.BuyerVO"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.vo.ProdVO"%>
<%@page import="kr.or.ddit.vo.PagingVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="/includee/preScript.jsp" />
</head>
<body>
	<%
		PagingVO<ProdVO> pagingVO = (PagingVO) request.getAttribute("pagingVO");
	%>
	<form id="searchForm"
		action="<%=request.getContextPath()%>/prod/prodList.do"
		class="form-inline">
		<input type="hidden" name="page" /> 
		<select class="form-control" name="prod_lgu">
			<option value>상품분류</option>
			<%
				List<Map<String, Object>> lprodList = (List) request.getAttribute("lprodList");
				for (Map<String, Object> lprod : lprodList) {
			%>
			<option value="<%=lprod.get("lprod_gu")%>"><%=lprod.get("lprod_nm")%></option>
			<%
				}
			%>
		</select> 
		<select class="form-control" name="prod_buyer">
			<option value>거래처</option>
			<%
				List<BuyerVO> buyerList = (List) request.getAttribute("buyerList");
				for (BuyerVO buyer : buyerList) {
			%>
			<option value="<%=buyer.getBuyer_id()%>"><%=buyer.getBuyer_name()%></option>
			<%
				}
			%>
		</select> 
		<input type="text" class="form-control" name="prod_name" /> 
		<input type="submit" class="btn btn-primary" value="검색" />
	</form>
	<br>
	<table id="prodTable" class="table table-bordered">
		<thead>
			<tr>
				<th>상품명</th>
				<th>상품분류</th>
				<th>거래처</th>
				<th>구매가</th>
				<th>판매가</th>
				<th>세일가</th>
			</tr>
		</thead>
		<tbody>
			<%
				List<ProdVO> datalist = pagingVO.getData();
				if (datalist != null && datalist.size() > 0) {
					for (ProdVO prod : datalist) {
			%>
			<tr>
				<td><a href="#" data-what="<%=prod.getProd_id()%>"><%=prod.getProd_name()%></a></td>
				<td><%=prod.getLprod_nm()%></td>
				<td><%=prod.getBuyer().getBuyer_name()%></td>
				<td><%=prod.getProd_cost()%></td>
				<td><%=prod.getProd_price()%></td>
				<td><%=prod.getProd_sale()%></td>
			</tr>
			<%
				}
				} else {
			%>
			<tr>
				<td colspan="6">검색 조건에 맞는 회원이 없음.</td>
			</tr>
			<%
				}
			%>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="6" id="pagingArea"><%=pagingVO.getPagingHTML_BS()%>
				</td>
			</tr>
		</tfoot>
	</table>
	<script type="text/javascript">
	let listTable = $("#prodTable")
	let pagingArea = $("#pagingArea");
	let searchForm = $("#searchForm");
	let pagingA = pagingArea.on('click', "a" ,function(){
		let page = $(this).data("page");
		searchForm.find("[name='page']").val(page);
		searchForm.submit();
		searchForm.find("[name='page']").val(1);
		return false;
	});
	
	$("#prodTable>tbody").on("click","a", function(){
		let what = $(this).data("what"); 
		location.href="<%=request.getContextPath()%>/prod/prodView.do?what=" + what;
	});
	
	searchForm.on("submit", function(event){
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
					$(list).each(function(idx, member){
						trTags.push(
							$("<tr>").append(
								$("<td>").html(
									($("<a>").text(prod.prod_name)
													.attr("href", "#")
													.data("what", prod.prod_id)
									),
								$("<td>").text(prod.lprod_nm),
								$("<td>").text(prod.buyer.buyer_name),
								$("<td>").text(prod.prod_cost),
								$("<td>").text(prod.prod_price),
								$("<td>").text(prod.prod_sale)
							)
						);
						
					});
				}else{
					trTags.push($("<tr>").html($("<td colspan='6'>").text("조건에 맞는 회원이 없음.")));
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
</body>
</html>