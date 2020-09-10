<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>새 프로젝트 올리기</title>
</head>
<body>
<h2>프로젝트 올리기</h2>

<form:form modelAttribute="projectForm" method="post">
<label for="name">프로젝트 이름</label>
<form:input path="name" />
<form:errors path="name" /> <br />

<label for="image">프로젝트 이미지</label>
<form:input path="image" />
<form:errors path="image" /> <br />

<label for="category">프로젝트 카테고리</label>
<form:select path="category" items="${categoryList}" />
<form:errors path="category" /> <br />

<label for="goalAmount">목표 금액</label>
<form:input path="goalAmount" />
<form:errors path="goalAmount" /> <br />

<label for="deadline">펀딩 마감일</label>
<form:input path="deadline" />
<form:errors path="deadline" /> <br />

<label for="product">상품 구성</label>
<form:input path="product.price" /> 원 이상 후원해주시는 분들께
<form:errors path="product.price" /> <br />

<form:input path="product.name" />
<form:errors path="product.name" /> <br />

<form:input path="product.description" />
<form:errors path="product.description" /> <br />

<!-- <label for="list">상품 리스트</label> -->
<!-- <table style="width:70%"> -->
<!-- 	<tr> <th>상품 이름</th> <th>가격</th></tr> -->
<%-- 	<c:forEach var="product" items="${products}" varStatus="status"> --%>
<!-- 		<tr> -->
<%-- 			<td>${product.name}</td> --%>
<%-- 			<td>${product.price}</td> --%>
<%-- 			<td><a href="product/delete?${product.name}">삭제</a></td> --%>
<!-- 		</tr> -->
<%-- 	</c:forEach> --%>
<!-- </table> -->
<!-- <br /> -->

<label for="description">프로젝트 소개</label>
<form:textarea path="description" />
<form:errors path="description" /> <br />
<br/>

<input type="submit" value="프로젝트 등록" />

</form:form>

</body>
</html>