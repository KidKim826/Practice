<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h2>글 상세보기</h2>
		<hr>
		<div class="card" style="width: 40rem;">
			<div class="card-body">
				<h5 class="card-title">${board.title }
					<span class="badge bg-danger">${board.viewCnt }</span>
				</h5>
				<div class="d-flex justify-content-between">
					<div class="card-subtitle mb-2 text-muted">${board.writer }</div>
					<div class="card-subtitle mb-2 text-muted">${board.regDate }</div>
				</div>
				<p class="card-text">${board.content }</p>
				<div>
					<%-- <form method="POST" action="board?act=updateform&id=${board.id }">
						<button type="submit">수정</button>
					</form> --%>

					<form method="POST" action="board">
						<input type="hidden" name="act" value="updateform"> <input
							type="hidden" name="id" value="${board.id }">
						<button type="submit">수정</button>
						<input type="hidden" name="id" value="${board.id }"> <input
							type="hidden" name="act" value="delete">
						<button type="submit">삭제</button>
						<input type="hidden" name="act" value="list">
						<button type="submit">목록</button>
					</form>


					<%-- <form method="POST" action="board">
						<input type="hidden" name="act" value="updateform"> <input
							type="hidden" name="act" value="delete"> <input
							type="hidden" name="act" value="list"> <a
							href="board?act=updateform&id=${board.id }">수정</a> <a
							href="board?act=delete&id=${board.id }">삭제</a> <a
							href="board?act=list">목록</a>
					</form> --%>
				</div>

			</div>
		</div>
	</div>
</body>
</html>