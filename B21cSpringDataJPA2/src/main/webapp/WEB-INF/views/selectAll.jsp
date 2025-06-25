<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %> 
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>데이터 조회</title>
	</head>
	<body>
		<%
			out.println("Spring JPA #2 - Insert");
		%>
		<ul>
			<li><a href="/">루트</a></li>
		</ul>
		
		<c:forEach items="${members }" var="member">
		아이디 : ${member.id } <br/>
		이  름 : ${member.name } <br/>
		이메일 : ${member.email } <br/>
		<hr/>
		</c:forEach>
	</body>
</html>