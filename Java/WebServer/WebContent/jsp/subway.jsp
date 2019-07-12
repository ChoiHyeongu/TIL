
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>
<%@page import="java.net.URLEncoder"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>거여동 지하철</title>
</head>
<body>
	<c:catch var="err">
		<c:import charEncoding="UTF-8" var="subway"
			url="http://swopenapi.seoul.go.kr/api/subway/sample/xml/realtimeStationArrival/1/5/%EA%B1%B0%EC%97%AC">
		</c:import>
		<!-- xml 파싱 -->
		<x:parse varDom="subway" xml="${subway}"></x:parse>
		<h2><x:out select="$subway/realtimeStationArrival/row/trainLineNm"></x:out></h2>
		시간 : <x:out select="$subway/realtimeStationArrival/row/recptnDt"></x:out>
		<br>
		내리는 문 : <x:out select="$subway/realtimeStationArrival/row/subwayHeading"></x:out>
		<br>
		상태 : <x:out select="$subway/realtimeStationArrival/row/arvlMsg2"></x:out>
		<br>

	</c:catch>
	<c:if test="${!empty err}">
		<h2>오류 발생!</h2>
		${err}
		</c:if>
</body>
</html>