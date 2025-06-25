<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %> 
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>데이터 입력</title>
	</head>
	<body>
		<h2>Spring boot 프로젝트</h2>
		<ul>
			<li><a href="/">루트</a></li>
		</ul>
		
		<h2>JPQL - @Query</h2>
		<c:if test="${not empty totalElements }">
			<h2>Pageable 적용 결과</h2>
			총 레코드 수 : ${totalElements } <br/>
			전체 페이지 수 : ${totalPages } <br/>
			페이지 당 레코드수 : ${size } <br/>
			페이지 번호 : ${pageNumber } <br/>
			엘리먼트(컨텐츠) 갯수 : ${numberOfElements } <br/>
			<hr/> 
		</c:if>
		
		<h3>레코드 출력</h3>
		<c:forEach var="member" items="${members }">
			<p>
				아이디 : ${member.id },
				이  름 : ${member.name },
				이메일 : ${member.email }
			</p>
		</c:forEach>
	</body>
</html>