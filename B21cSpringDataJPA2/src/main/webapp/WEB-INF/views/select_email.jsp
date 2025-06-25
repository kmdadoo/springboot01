<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %> 
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>데이터 조회 - email</title>
	</head>
	<body>
		<%
			out.println("Spring JPA #2 - Select By Email");
		%>
		<ul>
			<li><a href="/">루트</a></li>
		</ul>
		
		아이디 : ${member.id } <br/>
		이  름 : ${member.name } <br/>
		이메일 : ${member.email } 
	</body>
</html>