<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h4>${message }</h4>
<h4>${errors }</h4>
<form:form modelAttribute="fileVO" method="post" enctype="multipart/form-data"> <!-- commandName="fileVO" = modelAttribute="fileVO" -->
	<input type="text" name="uploader">
	<form:errors path="uploader" element="span" cssClass="error" /><br />
	<input type="file" name="uploadFile">
	<form:errors path="uploadFile" element="span" cssClass="error"/>
	<input type="submit" value="전송">
</form:form>
</body>
</html>