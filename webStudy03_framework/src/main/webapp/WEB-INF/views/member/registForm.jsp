<%@page import="org.apache.commons.lang3.StringUtils"%>
<%@page import="kr.or.ddit.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="/includee/preScript.jsp" />
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.2/jquery.validate.min.js"></script>
<script type="text/javascript">
	$(function() {
		var registForm = $("#registForm");
		var inInputTag = $("[name='mem_id']");
		$("input").addClass("form-control");
		inInputTag.on("change", function(){
			registForm.data("validId", false);
			$(this).next('.idMsg').remove();
		});
		registForm.on("submit", function(){
			let valid = $(this).data("validId");
			if(!valid){
				alert("아이디 중복 체크 하세요!");
				valid=false;
			}
			return valid;
		}).validate();
		$("#checkBtn").on("click", function(){
			let inputId = inInputTag.val();
			$.ajax({
				url : "<%=request.getContextPath()%>/idCheck.do",
				// inputId 파라미터로 중복 확인
				data : {
					inputId:inputId
				},
				method : "post",
				dataType : "json", // Accept(request), Content-Type(response)
				success : function(resp) {
					if(resp.valid){
						let msgTag = inInputTag.next(".idMsg");
						if(msgTag.length==0){
							inInputTag.after("<span class='idMsg'>아이디 사용가능</span>");
						}
						registForm.data("validId", true);
					}else{
						alert("아이디 중복, 사용불가능 합니다.");
						$("[name='mem_id']").focus();
					}
				},
				error : function(errResp) {
					console.log(errResp);
				}
			});
		});
		//우편번호 검색
		$("#searchZip").on("click",function(){
			var dongvalue = $('#dong').val();
			
			$.ajax({
				url : '<%=request.getContextPath()%>/zipSearch.do',
				type : 'post',
				data : {'dong' : dongvalue},
				success : function(res){					
					code = "<table>";
					code += "<tr><td>우편번호</td><td>주소</td><td>번지</td></tr>";
					$.each(res, function(i){
						code += "<tr class='ziptr'><td>" + res[i].code + "</td>";
						code += "<td>" + res[i].addr + "</td>";
						code += "<td>" + res[i].bunji + "</td></tr>"
					})
					code += "</table>";
				},
				error : function(xhr){
					alert("상태 : " + xhr.status);
				},
				dataType : 'json'
			})
		});
		
	
	<%String message = (String) request.getAttribute("message");
			if (StringUtils.isNotBlank(message)) {%>
	    	alert("<%=message%>");
<%}%>
	});
</script>
</head>
<jsp:useBean id="member" class="kr.or.ddit.vo.MemberVO" scope="request" />
<jsp:useBean id="errors" class="java.util.LinkedHashMap" scope="request" />
<body>
	<form id="registForm" method="post">
			<table class="table table-bordered">
				<tr>
					<th>아이디</th>
					<td><input type="text" name="mem_id" value="<%=member.getMem_id()%>" maxLength="15" required />
						<button type="button" id="checkBtn">아이디중복체크</button> 
						<span class="error"><%=errors.get("mem_id")%></span></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="text" name="mem_pass" value="<%=member.getMem_pass()%>" maxLength="15" required /> 
					<span class='error'><%=errors.get("mem_pass")%></span></td>
				</tr>
				<tr>
					<th>회원명</th>
					<td><input type="text" name="mem_name" value="<%=member.getMem_name()%>" maxLength="20" required /> 
					<span class='error'><%=errors.get("mem_name")%></span></td>
				</tr>
				<tr>
					<th>주민번호1</th>
					<td><input type="text" name="mem_regno1" value="<%=member.getMem_regno1()%>" maxLength="6" required /> 
					<span class='error'><%=errors.get("mem_regno1")%></span></td>
				</tr>
				<tr>
					<th>주민번호2</th>
					<td><input type="text" name="mem_regno2" value="<%=member.getMem_regno2()%>" maxLength="7" required /> 
					<span class='error'><%=errors.get("mem_regno2")%></span></td>
				</tr>
				<tr>
					<th>생일</th>
					<td><input type="date" name="mem_bir" value="<%=member.getMem_bir()%>" /> 
					<span class='error'><%=errors.get("mem_bir")%></span></td>
				</tr>
				<tr>
					<th>우편번호</th>
					<td><input type="text" name="mem_zip" value="<%=member.getMem_zip()%>" maxLength="7" required /> 
					<span class='error'><%=errors.get("mem_zip")%></span>
<!-- 					<input id="searchZip" style="width:150px" type="button" value="우편번호 검색" /> -->
					<button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">우편번호 검색</button>
					</td>
				</tr>
				<tr>
					<th>주소1</th>
					<td><input type="text" name="mem_add1"
						value="<%=member.getMem_add1()%>" maxLength="100" required /> <span
						class='error'><%=errors.get("mem_add1")%></span></td>
				</tr>
				<tr>
					<th>주소2</th>
					<td><input type="text" name="mem_add2"
						value="<%=member.getMem_add2()%>" maxLength="80" required /> <span
						class='error'><%=errors.get("mem_add2")%></span></td>
				</tr>
				<tr>
					<th>집전화</th>
					<td><input type="text" name="mem_hometel"
						value="<%=member.getMem_hometel()%>" maxLength="14" required /> <span
						class='error'><%=errors.get("mem_hometel")%></span></td>
				</tr>
				<tr>
					<th>회사전화</th>
					<td><input type="text" name="mem_comtel"
						value="<%=member.getMem_comtel()%>" maxLength="14" required /> <span
						class='error'><%=errors.get("mem_comtel")%></span></td>
				</tr>
				<tr>
					<th>휴대폰</th>
					<td><input type="text" name="mem_hp"
						value="<%=member.getMem_hp()%>" maxLength="15" /> <span
						class='error'><%=errors.get("mem_hp")%></span></td>
				</tr>
				<tr>
					<th>이메일</th>
					<td><input type="text" name="mem_mail"
						value="<%=member.getMem_mail()%>" maxLength="40" required /> <span
						class='error'><%=errors.get("mem_mail")%></span></td>
				</tr>
				<tr>
					<th>직업</th>
					<td><input type="text" name="mem_job"
						value="<%=member.getMem_job()%>" maxLength="40" /> <span
						class='error'><%=errors.get("mem_job")%></span></td>
				</tr>
				<tr>
					<th>취미</th>
					<td><input type="text" name="mem_like"
						value="<%=member.getMem_like()%>" maxLength="40" /> <span
						class='error'><%=errors.get("mem_like")%></span></td>
				</tr>
				<tr>
					<th>기념일</th>
					<td><input type="text" name="mem_memorial"
						value="<%=member.getMem_memorial()%>" maxLength="40" /> <span
						class='error'><%=errors.get("mem_memorial")%></span></td>
				</tr>
				<tr>
					<th>기념일자</th>
					<td><input type="date" name="mem_memorialday"
						value="<%=member.getMem_memorialday()%>" /> <span
						class='error'><%=errors.get("mem_memorialday")%></span></td>
				</tr>
				<tr>
					<th>마일리지</th>
					<td><input type="number" name="mem_mileage"
						value="<%=member.getMem_mileage()%>" maxLength="10" /> <span
						class='error'><%=errors.get("mem_mileage")%></span></td>
				</tr>
				<tr>
					<th>탈퇴여부</th>
					<td><input type="text" name="mem_delete"
						value="<%=member.getMem_delete()%>" maxLength="1" /> <span
						class='error'><%=errors.get("mem_delete")%></span></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="전송" /> <input
						type="reset" value="취소" /></td>
				</tr>
			</table>
			<!-- Modal -->
			<div id="myModal" class="modal fade" role="dialog">
			  <div class="modal-dialog">
			
			    <!-- Modal content-->
			    <div class="modal-content">
			      <div class="modal-header">
			        <h4 class="modal-title">우편번호 검색</h4>
			      </div>
			      <div class="modal-body">
			        <p>검색어 입력</p>
			        <input type="text" name="dong" />
			        <input id="searchZip" style="width:100px;" type="button" value="검색"/>
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-default" data-dismiss="modal">close</button>
			      </div>
			    </div>

			  </div>
			</div>
	</form>
</body>
</html>













