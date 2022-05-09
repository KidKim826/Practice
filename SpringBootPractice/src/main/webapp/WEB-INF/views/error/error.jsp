<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	${msg } <!-- ExceptionControllerAdvice에서 msg 속성을 받아서 출력 -->
	<a href="${root }/">메인으로 돌아가기</a>
</body>
</html>