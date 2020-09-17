<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/mycss.css">
<script src="../js/jquery-3.5.1.min.js"></script>
<script>
// 	$(function(){ 
// 		$('input:button').click(function(){
// 			//입력한 동이름 가져오기
// 			dongvalue = $('#dong').val();
			
// 			$.ajax({
// 				url : '/jqpro/DongDong',
// 				type : 'post',
// 				data : {'dong' : dongvalue},
// 				success : function(res){
					
// 					code = "<table>";
// 					code += "<tr><td>우편번호</td><td>주소</td><td>번지</td></tr>";
// 					$.each(res, function(i){
// 						code += "<tr class='ziptr'><td>" + res[i].code + "</td>";
// 						code += "<td>" + res[i].addr + "</td>";
// 						code += "<td>" + res[i].bunji + "</td></tr>"
// 					})
// 					code += "</table>";
// 					$('#result1').html(code);
// 				},
// 				error : function(xhr){
// 					alert("상태 : " + xhr.status);
// 				},
// 				dataType : 'json'
// 			})
// 		})
		
// 		/* 검색된 주소리스트에서 하나를 선택하는 이벤트 - delegate 방식  */
// 		$('#result1').on('click','.ziptr', function(){
			
// 			code = $('td:eq(0)', this).text();
// 			addr = $('td:eq(1)', this).text();
			
// 			$('#zip', opener.document).val(code);
// 			$('#add1', opener.document).val(addr);
			
// 			window.close();

// 		})
		
		
// 	})
</script>
<style>
	.ziptr:hover{
		background: lime;
	}
</style>
</head>
<body>

	<div class="box">
		동입력 <input type="text" id="dong">
		<input type="button" value="확인">
		<div id="result1"></div>
	</div>
</body>
</html>