<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>
</head>
<body>
	<h1>영화 등록 결과</h1>
	<h2>등록 영화정보</h2>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>항목</th>
				<th>내용</th>
			</tr>
		</thead>
		<tr>
			<td>영화 제목</td>
			<td>${movie.title }</td>
		</tr>
		<tr>
			<td>감독</td>
			<td>${movie.director }</td>
		</tr>
		<tr>
			<td>장르</td>
			<td>${movie.genre }</td>
		</tr>
		<tr>
			<td>상영시간</td>
			<td>${movie.runningTime }</td>
		</tr>
	</table>


	<c:if test="${!empty fileName }">
		<h2>포스터</h2>
		<img src="/movie/file/${fileName }">
	</c:if>

</body>
</html>