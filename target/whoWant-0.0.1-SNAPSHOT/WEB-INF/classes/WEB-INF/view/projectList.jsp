<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>프로젝트 목록 조회</title>
</head>
<body>
<h2>프로젝트 보기</h2>

<table style="width:70%">
	<tr>
		<th>프로젝트 제목</th><th>프로젝트 내용</th>
	</tr>
	<c:forEach var="project" items="${projects}" varStatus="status">
	<tr>
		<td><a href="<c:url value='/project/${project.projectId}' />">${project.name}</a></td>
		<td>${project.description}</td>
	</tr>
	</c:forEach>
</table>

<p><a href="<c:url value='/newProject' />">새 프로젝트 올리기</a></p>
</body>
</html>