<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>오늘 거여동 날씨</title>
<style>
table, td, th {
	border: 1px solid black;
}
</style>
</head>
<body>
	<c:catch var="err">
		<c:import var="weather"
			url="http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1171053100">
		</c:import>
		<!-- xml 파싱 -->
		<x:parse varDom="wrss" xml="${weather}"></x:parse>
		<h2><x:out select="$wrss/rss/channel/title"></x:out></h2>
		<br />
		<table>
			<tr>
				<th colspan="2">현재날씨</th>
			</tr>
			<tr>
				<td>기준시간</td>
				<td><x:out select="$wrss/rss/channel/pubDate" /></td>
			</tr>
			<tr>
				<td>날씨</td>
				<td><x:out
						select="$wrss/rss/channel/item/description/body/data/wfKor" /></td>
			</tr>
			<tr>
				<td>기온</td>
				<td><x:out
						select="$wrss/rss/channel/item/description/body/data/temp" /></td>
			</tr>
			<tr>
				<td>습도</td>
				<td><x:out
						select="$wrss/rss/channel/item/description/body/data/reh" /></td>
			</tr>
			<tr>
				<td>강수확률</td>
				<td><x:out
						select="$wrss/rss/channel/item/description/body/data/pop" /></td>
			</tr>
		</table>
	</c:catch>
	<c:if test="${!empty err}">
		<h2>오류 발생!</h2>
		${err}
		</c:if>
</body>
</html>