<%@page import="kr.or.ddit.servlet04.FileWrapper"%>
<%@page import="org.apache.commons.lang3.StringUtils"%>
<%@page import="java.nio.file.Paths"%>
<%@page import="java.nio.file.Path"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/jquery.fancytree/2.36.1/skin-win8/ui.fancytree.min.css">
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery-3.5.1.min.js"></script>
<script src="//code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery.fancytree/2.36.1/jquery.fancytree-all-deps.min.js"></script>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery.fancytree/2.36.1/jquery.fancytree-all.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#tree1").fancytree({
			  extensions: ["dnd5", "edit"],
		      selectMode: 1,
		      
		      lazyLoad: function(event, data){        
		        data.result = {
		        	url: "<%=request.getContextPath()%>/serverExplorer.do?url=" + data.node.key
								};
							},
							dnd5: {
						        preventVoidMoves: true, // Prevent moving nodes 'before self', etc.
						        preventRecursion: true, // Prevent dropping nodes on own descendants
						        preventSameParent: false, // Prevent dropping nodes under the same direct parent
						        autoExpandMS: 1000,
						        multiSource: true,  // drag all selected nodes (plus current node)
						        // focusOnClick: true,
						        // refreshPositions: true,
						        dragStart: function(node, data) {
						          // allow dragging `node`:
						          data.effectAllowed = "all";
						          data.dropEffect = data.dropEffectSuggested;  //"link";
						           // data.dropEffect = "move";
						          return true;
						        },
						        // dragDrag: function(node, data) {
						        //   data.node.info("dragDrag", data);
						        //   data.dropEffect = "copy";
						        //   return true;
						        // },
						        dragEnter: function(node, data) {
						          data.node.info("dragEnter", data);
						          // data.dropEffect = "link";
						          return true;
						        },
						        dragOver: function(node, data) {
						          // data.node.info("dragOver", data);
						          data.dropEffect = data.dropEffectSuggested;  //"link";
						          return true;
						        },
						        dragEnd: function(node, data) {
						          data.node.info("dragEnd", data);
						        },
						        dragDrop: function(node, data) {
						          // This function MUST be defined to enable dropping of items on the tree.
						          //
						          // The source data is provided in several formats:
						          //   `data.otherNode` (null if it's not a FancytreeNode from the same page)
						          //   `data.otherNodeData` (Json object; null if it's not a FancytreeNode)
						          //   `data.dataTransfer.getData()`
						          //
						          // We may access some meta data to decide what to do:
						          //   `data.hitMode` ("before", "after", or "over").
						          //   `data.dropEffect`, `.effectAllowed`
						          //   `data.originalEvent.shiftKey`, ...
						          //
						          // Example:

						          var sourceNodes = data.otherNodeList,
						            copyMode = data.dropEffect !== "move";

						          if( data.hitMode === "after" ){
						            // If node are inserted directly after tagrget node one-by-one,
						            // this would reverse them. So we compensate:
						            sourceNodes.reverse();
						          }
						          if( copyMode ) {
						            $.each(sourceNodes, function(i, o){
						              o.info("copy to " + node + ": " + data.hitMode);
						              o.copyTo(node, data.hitMode, function(n){
						                delete n.key;
						                n.selected = false;
						                n.title = "Copy of " + n.title;
						              });
						            });
						          } else {
						            $.each(sourceNodes, function(i, o){
						              o.info("move to " + node + ": " + data.hitMode);
						              o.moveTo(node, data.hitMode);
						            });
						          }
						          node.debug("drop", data);
						          node.setExpanded();
						        }
						      }
						    });
	})
</script>
</head>
<body>
	<h4>Model2 구조로 webStudy01 컨텍스트의 익스플로러 구현</h4>
	<!-- ** 현재 컨텍스트에 있는 리소스들을 대상으로 한 익스플로러 구현 -->
	<!-- 1. 파라미터가 없는 경우, 컨텍스트 루트의 모든 자식 리소스를 목록으로 제공함. -->
	<!-- 2. 이후 모든 처리는 이클립스의 project explorer 뷰를 참고하여, 구현함. -->
	<div id="tree1">
		<ul>
			<%
				FileWrapper[] listFiles = (FileWrapper[]) request.getAttribute("listFiles");

				for (FileWrapper file : listFiles) {
					// int(기본형) Integer(객체형)
					// Map<>
					//JSP 쪽의 자바 코드 부담을 줄이려면? Adapter(Wrapper) 패턴을 사용해 보시오!!
			%>
			<li class="<%=file.getClz()%>" id="<%=file.getKey()%>"><%=file.getTitle()%></li>
			<%
				}
			%>
		</ul>
	</div>
	<%-- 	<li class="<%=clz %>" id="/01"><%=file.getName() %></li> --%>
</body>
</html>
