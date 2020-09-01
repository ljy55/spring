<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>03/standard.jsp</title>
</head>
<body>
<h4>JSP(Java Server Page)</h4>
<pre>
	: template 기반의 스크립트 코드 형태를 가진 스펙.
	
	** JSP 소스 구성 요소 (View 제작에 특화)
	1. 정적 텍스트  : HTML, JavaScript, CSS, 일반 텍스트...
	2. Scriptlet
		1) Directive(지시자) &lt;%@ 지시자명 속성="값" %&gt; : JSP 페이지에 대한 환경 설정 혹은 전처리에 사용됨.
			- page : 설정 정보  / 37p
			- include : 동적 내포
			- taglib : custom tag library 로딩에 사용.
		2) scriptlet <% 
						//자바코드
						String test = "text";
						for(int i = 0; i <= 5; i++){ //지역화(in method : _jspService)
							%>
							<%=String.format("%s, %d 번째\n", test, i) %>
							<% 
						}
					 %>
		3) Expression(표현식) <%="출력하고 싶은 값" %>, <%=test %>
		4) Declaration(선언식) 
<%! 
	public static String sample = "전역변수"; //이렇게 해도 전역변수로 못씀...그래서 나중에 등장하는게 스코프?
%>
		5) Comment(주석) <%-- --%>
			- client side comment : html, css, javascript
			- server side comment : java, jsp
		
	MVC
	SRP : 단일 책임의 원칙(역할의 분리) - 디자인패턴
	OCP
	LSP
	ISP
	DIP
	
	3. 기본객체
	4. 액션태그
	5. EL(표현언어)
	6. JSTL(tag library)
</pre>
</body>
</html>






