<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>home 화면</title>
	</head>
	<body>
		<h2>Spring Data JPA</h2>
		<ul>
			<li><a href="/insert.do">데이터 추가</a></li>
			<li><a href="./selectAll.do">전체조회</a></li>
			<li><a href="./selectById.do?id=1">개별조회 - byId</a></li>
			<li><a href="./selectByName.do?name=을지문덕">개별조회 - byName</a></li>
			<li><a href="./selectByEmail.do?email=test7@test.com">개별조회 - byEmail</a></li>
			<li><a href="./selectByNameLike.do?name=김">개별조회 - Name Like</a></li>
			<li><a href="./selectByNameLikeNameDesc.do?name=김">개별조회 - Name Like Name Desc</a></li>
			<li><a href="./selectByNameLikeOrder.do?name=김">개별조회 - Name Like Name Desc(Sort 사용)</a></li>
		</ul>
	</body>
</html>