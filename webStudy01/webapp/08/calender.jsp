<%@page import="java.util.Locale"%>
<%@page import="java.text.DateFormatSymbols"%>
<%@page import="java.util.Calendar"%>
<%@page import="static java.util.Calendar.*"%> <!-- static import 1.7버전 이후에서만 쓰임 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>04/calendar.jsp</title>
<style>
	td, th {
		border :  1px solid black;
	}
	table {
		border-collapse: collapse;
		width : 100%;
		height: 500px;
	}
</style>
<script type="text/javascript">
	function clickHandler(year, month){
		// form태그가 가지고 있는 input, select 태그들의 값을 변경시켜준다.
		console.log(document.calendarForm);
		var form = document.calendarForm;
		console.log(form.year);
		console.log(form.month);
		form.year.value = year;
		form.month.value = month;
		form.submit();
	}
</script>
</head>
<%
	String yearParam = request.getParameter("year");
	String monthParam = request.getParameter("month");
	String language = request.getParameter("language");
	
	Calendar cal = getInstance();
	if(yearParam != null && yearParam.matches("\\d{4}") && monthParam != null && monthParam.matches("\\d{1,2}")){
		cal.set(YEAR, Integer.parseInt(yearParam));
		cal.set(MONTH, Integer.parseInt(monthParam));
	}
	int maxDay = cal.getActualMaximum(DAY_OF_MONTH); // 마지막 날짜
	int year = cal.get(YEAR);
	int month = cal.get(MONTH);
	cal.set(DAY_OF_MONTH, 1); // 1월 1일이 됨.
	int offset = cal.get(DAY_OF_WEEK) - 1; // 1일의 요일
	cal.add(MONTH, -1); // 현재 캘린더는 19년도 12월 1일로 됨
	int beforeYear = cal.get(YEAR); // 2019
	int beforeMonth = cal.get(MONTH); // 전달 월 (12)
	cal.add(MONTH, 2); // 현재 캘린더는 20년도 9월이 됨
	int nextYear = cal.get(YEAR); // 2020
	int nextMonth = cal.get(MONTH);
	
	//Locale locale = Locale.CANADA_FRENCH;
	Locale locale = request.getLocale();
	if(language != null && language.trim().length() > 0){
		locale = Locale.forLanguageTag(language);
	}
	DateFormatSymbols dfs = new DateFormatSymbols(locale);
	String[] weekdays = dfs.getShortWeekdays();
	String[] months = dfs.getMonths();
%>
<body>
<!-- **jsp를 이용한 달력 구현 -->
<!-- 1. 선택 년도와 월이 없으면, 현재 달력을 랜더링 -->
<!-- 2. 이전달과 다음달의 달력 처리 -->
<!-- 3. 임의의 년도와 월의 달력 처리 -->
<!-- 4. 제공한 언어의 목록 중 선택한 Locale 이용한 언어별 달력 처리 -->
<!-- 5. 제공한 TimeZone 목록 중 선택한 TimeZone을 이용하여 오늘 날짜에 대한 식별 처리 -->
<form name="calendarForm">
	<input type="number" name="year" value="<%=year%>"/>년
	<select name="month">
		<%for(int i = 0; i < months.length-1; i++){%>
		<option value="<%=i%>" <%=i==month?"selected":""%>><%=months[i]%></option>
		<%}%>
	</select>
	<select name="language">
		<%
			Locale[] locales = Locale.getAvailableLocales();
			for(Locale tmp : locales){
				String text = tmp.getDisplayLanguage(tmp);
				if(text == null || text.trim().length() == 0) continue;
				String code = tmp.toLanguageTag();
				String selected = tmp.equals(locale) ? "selected" : "";
		%>
		<option value="<%=code%>" <%=selected%>><%=text%></option>
		<%		
			}
		%>
	</select>
	<input type="submit" value="달력" />
</form>
<table>
	<thead>
		<tr>
			<%
				for(int col = 1; col <= 7; col++){
			%>
					<th><%=weekdays[col]%></th>
			<%		
				}
			%>
		</tr>
	</thead>
	<tbody>
		<%
			int count = 1;
			String ptrn = "<td>%s</td>";
			for(int row = 1; row <= 6; row++){
				out.println("<tr>");
				for(int col = 1; col <= 7; col++){
					int dayCount = count++ - offset;
					String display = dayCount > 0 && dayCount <= maxDay ? (dayCount+"") : "&nbsp;";
					out.println(String.format(ptrn, display));					
				}
				out.println("</tr>");
			}
		%>
	</tbody>
</table>
</body>
</html>