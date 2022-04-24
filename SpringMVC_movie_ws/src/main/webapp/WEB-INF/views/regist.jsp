<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>SSAFY 영화 관리</h2>
	<br>
	<form action ="regist" method="post" enctype="multipart/form-data">
	<fieldset>
        <legend>영화 정보 입력</legend>
		제목: <input type="text" name="title"> <br> 
		감독: <input type="text" name ="director"> <br>
		장르: <input type="text" name ="genre"> <br>
		상영 시간: <input type="number" name ="runningTime"> <br>
		포스터: <input type="file" name ="upload_file"> <br>
		<input type="submit" value="등록">
		<input type="reset" value="초기화">
    </fieldset>
	</form>
	<br><a href="">홈으로</a>
	
</body>
</html>