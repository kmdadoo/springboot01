<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>home 화면</title>
	</head>
	<body>
		<h2>Pageable(페이징 적용)</h2>
		<ul>
			<li><a href="./selectByNameLike.do?name=test&page=1">Name Like 조회(1page)</a></li>
			<li><a href="./selectByNameLike.do?name=test&page=2">Name Like 조회(2page)</a></li>
			<li><a href="./selectByNameLike.do?name=test&page=3">Name Like 조회(3page)</a></li>
			<li><a href="./selectByNameLike.do?name=test&page=4">Name Like 조회(4page)</a></li>
		</ul>
	</body>
</html>