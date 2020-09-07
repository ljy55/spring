<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% request.setCharacterEncoding("UTF-8"); %>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
</script>

<title>Join</title>
 
<meta charset="UTF-8">
</head>
<body>
    <div class="box">
		<br><br>
		
		<div class="container">
		  <h2 id="title">회원가입</h2>
		  <form class="form-horizontal" id="ff">
		    
		    <div class="form-group">
		      <label class="control-label col-sm-2" for="id">아이디:</label>
		      <div class="col-sm-7">
		        <input type="text" class="form-control" id="id" placeholder="아이디를 입력해주세요" name="mem_id">
		      </div>
		        <button id="btnid" type="button" class="btn btn-success">중복검사</button>
		        <span id="idchk"></span>
		    </div>
		    
		    <div class="form-group">
		      <label class="control-label col-sm-2" for="name">이름:</label>
		      <div class="col-sm-7">
		        <input type="text" class="form-control" id="name" placeholder="이름을 입력해주세요" name="mem_name">
		      </div>
		    </div>
		    
		    <div class="form-group">
		      <label class="control-label col-sm-2" for="bir">생년월일:</label>
		      <div class="col-sm-7">
		        <input type="text" class="form-control" id="bir" placeholder="1994 04 15" name="mem_bir">
		      </div>
		    </div>
		    
		    <div class="form-group">
		      <label class="control-label col-sm-2" for="pass">비밀번호:</label>
		      <div class="col-sm-7">
		        <input type="password" class="form-control" id="pass" placeholder="비밀번호를 입력해주세요" name="mem_pass">
		      </div>
		    </div>
		   
		    <div class="form-group">
		      <label class="control-label col-sm-2" for="hp">휴대폰번호:</label>
		      <div class="col-sm-7">
		        <input type="text" class="form-control" id="hp" placeholder="010 1234 5678" name="mem_hp">
		      </div>
		    </div>
		    
		    
		    <div class="form-group">
		      <label class="control-label col-sm-2" for="email">Email:</label>
		      <div class="col-sm-7">
		        <input type="email" class="form-control" id="email" placeholder="abc@email.com" name="mem_mail">
		      </div>
		    </div>
		    
		    <div class="form-group">
		      <label class="control-label col-sm-2" for="zip">우편번호:</label>
		      <div class="col-sm-7">          
		        <input type="text" class="form-control" id="zip" placeholder="우편번호를 입력해주세요" name="mem_zip">
		      </div>
		        <!-- <button type="button" class="btn btn-success" id="myBtn">번호검색</button> -->
		        <button type="button" data-toggle="modal" data-target="#myModal" class="btn btn-success">번호검색</button>
		    </div>
		    
		    <div class="form-group">
		      <label class="control-label col-sm-2" for="add1">주소:</label>
		      <div class="col-sm-7">
		        <input type="text" class="form-control" id="add1" placeholder="주소를 입력해주세요" name="mem_add1">
		      </div>
		    </div>
		    
		    <div class="form-group">
		      <label class="control-label col-sm-2" for="add2">상세주소:</label>
		      <div class="col-sm-7">
		        <input type="text" class="form-control" id="add2" placeholder="상세주소를 입력해주세요" name="mem_add2">
		      </div>
		    </div>
		 
		    <div class="form-group">        
		      <div class="col-sm-offset-2 col-sm-10">
		        <button id="btnjoin" type="button" class="btn btn-default">제출</button>
		        <span id="joinres"></span>
		        <button type="reset" class="btn btn-default">초기화</button>
		      </div>
		      <div class="col-sm-offset-2 col-sm-10">
		        
		      </div>
		    </div>
		  </form>
		</div>
	
	</div>
</body>
</html>
