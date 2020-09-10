<%@ include file="IncludeTop.jsp" %>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>

<div class="container" style="margin-top:20px">

	<h4 class="my-5">${userSession.account.name}님이 만든 프로젝트</h4>
	
	<table class="table table-hover">
		<thead>
			<tr>
				<th scope="col">프로젝트 제목</th>
				<th scope="col">펀딩 마감일</th>
				<th scope="col"></th>
				<th scope="col"></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="project" items="${projects}" varStatus="status">
			<tr valign=middle>
				<td><a href="<c:url value='/project/${project.projectId}' />">${project.name}</a></td>
				<td>${project.deadline}</td>
				<td><a onclick="return confirm('수정하시겠습니까?')" href="<c:url value='/editProject/step1?projectId=${project.projectId}' />">수정</a></td>
				<td><a onclick="return confirm('삭제하시겠습니까?')" href="<c:url value='/removeProject?projectId=${project.projectId}' />">삭제</a></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>

</div>

<%@ include file="IncludeBottom.jsp"%>