<%@ include file="IncludeTop.jsp" %>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>

<c:set var="result" value="${result}" />

<div class="container">
  <div class="text-center my-5">
	<c:choose>
		<c:when test="${result eq '등록'}">
			<h5>프로젝트가 등록되었습니다.</h5>
		</c:when>
		
		<c:when test="${result eq '수정'}">
			<h5>프로젝트가 수정되었습니다.</h5>
		</c:when>
		
		<c:when test="${result eq '삭제'}">
			<h5>프로젝트가 삭제되었습니다.</h5>
		</c:when>
		
		<c:when test="${result eq '후원'}">
			<h5>프로젝트 후원이 완료되었습니다.</h5>
		</c:when>
	</c:choose>
  </div>
</div>

<%@ include file="IncludeBottom.jsp"%>
