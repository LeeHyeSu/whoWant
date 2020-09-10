<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>프로젝트 상세 조회</title>
</head>
<body>

프로젝트 이름: ${project.name} <br />	
프로젝트 이미지: ${project.image} <br />
프로젝트 카테고리: ${project.category} <br /> 
목표 금액: ${project.goalAmount} <br />	
펀딩 마감일: ${project.deadline}	<br />
<br />
<%-- 모인 금액		${ } --%>
<%-- 후원 인원		${ } --%>
<%-- 마감까지 		${ } --%>

<br>
<%-- 후원하기로 가는 버튼 --%>

<%-- 문의하기로 가는 버튼 --%>

<br>
<%-- [프로젝트 소개] <br />
${project.description} <br />
상품 이름
${project.product.name} <br />
상품 소개
${project.product.description} <br /> --%>

<p><a href="<c:url value='/projectList' />">프로젝트 리스트 조회</a></p>

</body>
</html>