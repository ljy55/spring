<%@page import="kr.or.ddit.vo.ProdVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.vo.BuyerVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="/includee/preScript.jsp"/>
</head>
<body>
	<%
		BuyerVO buyer = (BuyerVO) request.getAttribute("buyer");
	%>
	<table class="table table-bordered">
		<tr>
			<th>제품 아이디</th>
			<td><%=buyer.getBuyer_id()%></td>
		</tr>
		<tr>
			<th>제품 이름</th>
			<td><%=buyer.getBuyer_name()%></td>
		</tr>
		<tr>
			<th>제품 분류</th>
			<td><%=buyer.getLprod_nm() %></td>
		</tr>
		<tr>
			<th>계좌명</th>
			<td><%=buyer.getBuyer_bank()%></td>
		</tr>
		<tr>
			<th>계좌번호</th>
			<td><%=buyer.getBuyer_bankno()%></td>
		</tr>
		<tr>
			<th>예금주명</th>
			<td><%=buyer.getBuyer_bankname()%></td>
		</tr>
		<tr>
			<th>우편번호</th>
			<td><%=buyer.getBuyer_zip()%></td>
		</tr>
		<tr>
			<th>주소1</th>
			<td><%=buyer.getBuyer_add1()%></td>
		</tr>
		<tr>
			<th>주소2</th>
			<td><%=buyer.getBuyer_add2()%></td>
		</tr>
		<tr>
			<th>회사번호</th>
			<td><%=buyer.getBuyer_comtel()%></td>
		</tr>
		<tr>
			<th>팩스번호</th>
			<td><%=buyer.getBuyer_fax()%></td>
		</tr>
		<tr>
			<th>메일</th>
			<td><%=buyer.getBuyer_mail()%></td>
		</tr>
		<tr>
			<th>담당자</th>
			<td><%=buyer.getBuyer_charger()%></td>
		</tr>
		<tr>
			<th>?</th>
			<td><%=buyer.getBuyer_telext()%></td>
		</tr>
	</table>
	<table class="table table-bordered">
					<thead class="thead-dark">
						<tr>
							<th>제품명</th>
							<th>제품원가</th>
							<th>판매가격</th>
							<th>할인가격</th>
							<th>제품개요</th>
							<th>마일리지</th>
						</tr>
					</thead>
					<tbody>
						<%
							List<ProdVO> prodList = buyer.getProdList();
							if(prodList!=null && prodList.size()>0){
								for(ProdVO prod : prodList){
									%>
						<tr>
							<td><%=prod.getProd_name() %></td>
							<td><%=prod.getProd_cost() %></td>
							<td><%=prod.getProd_price() %></td>
							<td><%=prod.getProd_sale() %></td>
							<td><%=prod.getProd_outline() %></td>
							<td><%=prod.getProd_mileage() %></td>
						</tr>
						<%
								}
							}else{
								%>
						<tr>
							<td colspan="5">상품이 없음.</td>
						</tr>
						<%
							}
						%>
					</tbody>
				</table>

</body>
</html>