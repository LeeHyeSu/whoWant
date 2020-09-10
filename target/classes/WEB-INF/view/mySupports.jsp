<%@ include file="IncludeTop.jsp" %>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>

<div class="container" style="margin-top:20px">

	<h4 class="my-5">${userSession.account.name}님의 후원 현황</h4>
	
	<table class="table table-hover">
		<thead>
			<tr>
				<th scope="col">프로젝트 이름</th>
				<th scope="col">선택한 상품</th>
				<th scope="col">후원 금액</th>
				<th scope="col">후원 날짜</th>
				<th scope="col">결제 방법</th>
				<th scope="col"></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="support" items="${supports}" varStatus="status">
			<tr>
				<td><a href="<c:url value='/project/${support.projectId}' />">${support.projectName}</a></td>
				<td>${support.productName}</td>
				<td><fmt:formatNumber value="${support.amount}" pattern="#,###"/></td>
				<td>${support.supportDate}</td>
				<td>${support.paymentOption}</td>
				<td><a onclick="return confirm('후원을 취소하시겠습니까?')" href="<c:url value='/removeSupport?projectId=${support.projectId}' />">취소</a></td>
			</tr>
			</c:forEach>
		<tbody>
	</table>

</div>

<%@ include file="IncludeBottom.jsp"%>