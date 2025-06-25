<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %> 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>total_view</title>
	</head>
	<body>
		<h2>Spring Boot 프로젝트</h2>
		<ul>
			<li><a href="/">루트</a></li>
		</ul>
		
		<h2>Spring Data JPA - ${ title }</h2>
		<c:if test="${ mode eq 0 }">
			<p>
				${ result }
			</p>
		</c:if>
		
		<c:if test="${ mode eq 1 }">
			<p>
				아이디 : ${ result.id }<br/>
				이  름 : ${ result.name }<br/>
				이메일 : ${ result.email }
			</p>
		</c:if>
		
		<c:if test="${ mode eq 2 }">
			<c:forEach items="${ result }" var="member">
				<p>
					아이디 : ${member.id }<br/>
					이  름 : ${member.name }<br/>
					이메일 : ${member.email }
				</p>
			</c:forEach>
		</c:if>
	</body>
</html>