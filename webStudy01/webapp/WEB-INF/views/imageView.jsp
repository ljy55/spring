<%@page import="org.apache.commons.lang3.StringUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
	$(function(){
		var imgPtrn = "<img src = 'image.do?image=%S'/>";
		var videoPtrn = "<video src = 'image.do?image=%S'/>";
		var resultArea = $("#resultArea");
		$("select").on("change", function(){
			let value = $(this).val();
			let option = $(this).find("option:selected");
			//$(option).attr("value");
			//option[0].value
			let clzName = $(option).attr("class");
			let innerTag = null;
			if(clzName.startsWith("image")){
				//let imgTag = imgPtrn.replace("%S", value);
				//resultArea.html(imgTag);
				innerTag = imgPtrn.replace("%S", value);
			}else if(clzName.startsWith("video")){
				//let videoTag = videoPtrn.replace("%S", value);
				//resultArea.html(videoTag);
				innerTag = videoPtrn.replace("%S", value);
			}
			if(innerTag){
				resultArea.html(innerTag);
			}
			
		});
	});
</script>
	<select>
		<option>파일선택</option>
		<%
			String[] listFiles = (String[])request.getAttribute("listFiles");
			for(String file : listFiles){
				String mime = application.getMimeType(file);
				String clz = StringUtils.startsWith(mime, "image/")?"image":StringUtils.startsWith(mime, "video")?"viedo":"none";
				%>
				<option class="<%=clz%>"><%=file %></option>
				<%
			}
		%>
	</select>
	<div id="resultArea">
	
	</div>