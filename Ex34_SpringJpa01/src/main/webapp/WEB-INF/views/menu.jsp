<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	out.println("Spring JPA #01");
%>
<br><p>

<a href=/insert?username=test1>데이터 추가</a>
<a href=/select?id=1>개별 조회</a>
<a href=/selectAll>전체 조회</a>
<a href=/delete?id=2>데이터 삭제</a>
<a href=/update?id=1&username=홍길동>데이터 수정</a>
</body>
</html>