<%@ include file="IncludeTop.jsp" %>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
 
<div class="container" style="margin-top:20px">
	<h4 class="my-4">카테고리</h4>
	
	<c:forEach var="category" items="${categoryList}" varStatus="status">
	  <div class="my-2" style="letter-spacing: 0.5px;">
		<strong><a href="<c:url value='/projects?category=${category.name}' />">${category.name}</a></strong> 
		<small>${category.description}</small> <br />
      </div>
	</c:forEach>
</div>

<%@ include file="IncludeBottom.jsp"%>