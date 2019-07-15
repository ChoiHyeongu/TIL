
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <%-- JSTL 사용을 위한 core 라이브러리 추가 --%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%> <%-- XML 파싱을 위한 라이브러리 추가 --%>
<%@page import="java.net.URLEncoder"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>거여동 지하철</title>

<style>
table, td, th {
	border: 1px solid black;
}
</style>

</head>
<body>
	<c:catch var="err"> <%-- 예외가 생길 시 err이라는 변수에 발생된 예외를 저장 --%>
		<c:import charEncoding="UTF-8" var="subway" url="http://swopenapi.seoul.go.kr/api/subway/sample/xml/realtimeStationArrival/0/5/%EA%B1%B0%EC%97%AC">
		<%-- 실시간 지하철 XML 정보를 surbway라는 이름으로 저장 인코딩 문제 때문에 charEncoding을 UTF-8로 설정 --%>
		</c:import>
		<!-- xml 파싱 -->
		<x:parse varDom="subway" xml="${subway}"></x:parse> <%-- xml 문서를 읽어 subway라는 이름의 DOM객체를 생성--%>
		<table>
			<tr>
				<th colspan="2"><x:out
						select="$subway/realtimeStationArrival/row/trainLineNm"></x:out></th> <%-- trainLineNm부분의 데이터를 가져와 출력 --%>
			</tr>
			<tr>
				<td>시간</td>
				<td><x:out select="$subway/realtimeStationArrival/row/recptnDt"></x:out></td> <%-- recptnDt부분의 데이터를 가져와 출력 --%>
			</tr>
			<tr>
				<td>내리는 문</td>
				<td><x:out
						select="$subway/realtimeStationArrival/row/subwayHeading"></x:out></td> <%-- subwayHeading부분의 데이터를 가져와 출력  --%>
			</tr>
			<tr>
				<td>상태</td>
				<td><x:out select="$subway/realtimeStationArrival/row/arvlMsg2"></x:out></td> <%-- arvlMsg2부분의 데이터를 가져와 출력 --%>
			</tr>
		</table>
	</c:catch>
	<c:if test="${!empty err}"> <%-- 만만약 오류 발생시 오류 발생!을 출력하고 오류 출력 --%>
		<h2>오류 발생!</h2>
		${err}
		</c:if>
</body>
</html>