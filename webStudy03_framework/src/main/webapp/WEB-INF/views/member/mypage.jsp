<%@page import="kr.or.ddit.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member/mypage.jsp</title>
<jsp:include page="/includee/preScript.jsp" />
<script type="text/javascript">
	$(function(){
		$("#modifyBtn").on("click", function(){
			var answer = confirm("수정하시겠습니까?");
			if(answer==true){
				location.href="<%=request.getContextPath()%>/myDataUpdate.do";
			}
		});
		 
		var leaveBtn = $(".modal-body leaveBtn");
		leaveBtn.on("click", function(){
			var answer = confirm("탈퇴하시겠습니까?");
		})
		
	});
</script>
</head>
<jsp:useBean id="person" class="kr.or.ddit.vo.MemberVO" scope="request" />
<body>
	<!-- table 태그를 이용하여, 현재 로그인된 유저의 모든 정보를 출력. -->
	<%
		MemberVO authMember = (MemberVO) request.getAttribute("authMember");
	%>
	<table class="table table-bordered">
		<tr>
			<th>아이디</th>
			<td><%=authMember.getMem_id()%></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><%=authMember.getMem_pass()%></td>
		</tr>
		<tr>
			<th>회원명</th>
			<td><input type="text" name="mem_name" value="<%=authMember.getMem_name()%>" maxLength="20" required /></td>
		</tr>
		<tr>
			<th>주민번호1</th>
			<td><%=authMember.getMem_regno1()%></td>
		</tr>
		<tr>
			<th>생일</th>
			<td><%=authMember.getMem_bir()%></td>
		</tr>
		<tr>
			<th>우편번호</th>
			<td><%=authMember.getMem_zip()%></td>
		</tr>
		<tr>
			<th>주소1</th>
			<td><input type="text" name="mem_add1"
						value="<%=authMember.getMem_add1()%>" maxLength="100" required /></td>
		</tr>
		<tr>
			<th>주소2</th>
			<td><input type="text" name="mem_add1"
						value="<%=authMember.getMem_add2()%>" maxLength="100" required /></td>
		</tr>
		<tr>
			<th>집전번</th>
			<td><input type="text" name="mem_hometel"
						value="<%=authMember.getMem_hometel()%>" maxLength="14" required /></td>
		</tr>
		<tr>
			<th>회사전번</th>
			<td><input type="text" name="mem_comtel"
						value="<%=authMember.getMem_comtel()%>" maxLength="14" required /></td>
		</tr>
		<tr>
			<th>휴대폰</th>
			<td><input type="text" name="mem_hp"
						value="<%=authMember.getMem_hp()%>" maxLength="15" /></td>
		</tr>
		<tr>
			<th>이메일</th>
			<td><input type="text" name="mem_mail"
						value="<%=authMember.getMem_mail()%>" maxLength="40" required /></td>
		</tr>
		<tr>
			<th>직업</th>
			<td><input type="text" name="mem_job"
						value="<%=authMember.getMem_job()%>" maxLength="40" /></td>
		</tr>
		<tr>
			<th>취미</th>
			<td><input type="text" name="mem_like"
						value="<%=authMember.getMem_like()%>" maxLength="40" /></td>
		</tr>
		<tr>
			<th>기념일</th>
			<td><input type="text" name="mem_memorial"
						value="<%=authMember.getMem_memorial()%>" maxLength="40" /></td>
		</tr>
		<tr>
			<th>기념일자</th>
			<td><input type="date" name="mem_memorialday"
						value="<%=authMember.getMem_memorialday()%>" /></td>
		</tr>
		<tr>
			<th>마일리지</th>
			<td><%=authMember.getMem_mileage()%></td>
		</tr>
		<tr>
			<th>탈퇴여부</th>
			<td><%=authMember.getMem_delete()%></td>
		</tr>
		<tr>
			<td colspan="2">
				<input id="modifyBtn" type="button" value="수정하기">
				<input id="deleteBtn" type="button" value="탈퇴" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">
				<input type="reset" value="취소">
			</td>
		</tr>
	</table>
	<!-- Modal -->
	<div id="myModal" class="modal fade" role="dialog">
	  <div class="modal-dialog">
	
	    <!-- Modal content-->
	    <div class="modal-content">
	      <div class="modal-header">
	        <h4 class="modal-title">회원탈퇴</h4>
	      </div>
	      <div class="modal-body">
	        <p>비밀번호 입력</p>
	        <input type="text" name="passCheck" />
	        <input id="leaveBtn" style="width:100px;" type="button" value="탈퇴하기"/>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">close</button>
	      </div>
	    </div>

	  </div>
	</div>
</body>
</html>