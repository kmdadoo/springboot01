<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %> 
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>main</title>
	</head>
	<body>
		<%
			out.println("Spring JPA #2");
		%>
		<ul>
			<li><a href=/insert>데이터 추가</a></li>
			<li><a href=/selectAll>전체조회</a></li>
			<li><a href=/selectById?id=1>개별조회 - byId</a></li>
			<hr/>
			<li><a href=/selectByName?name=을지문덕>개별조회 - byName</a></li>
			<li><a href=/selectByEmail?email=test7@test.com>개별조회 - byEmail</a></li>
			<li><a href=/selectByNameLike?name=김>개별조회 - Name Like</a></li>
			<li><a href=/selectByNameLikeNameDesc?name=김>리스트 조회 - Name Like Name Desc</a></li>
			<li><a href=/selectByNameLikeOrder?name=김>리스트 조회 - Name Like Name Desc(Sort 사용)</a></li>
		</ul>
	</body>
</html>