<%@ include file="IncludeTop.jsp" %>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>

<div class="container" style="margin-top:20px">

	<c:if test="${!empty category}">
	 	<h5 class="my-4"><span class="badge badge-primary" style="display:table; margin-left:auto; margin-right:auto;"><c:url value="${category}" /></span></h5>
	</c:if>	
	<c:if test="${!empty keyword}">
	 	<h5 class="my-4"><span class="badge badge-primary" style="display:table; margin-left:auto; margin-right:auto;"><c:url value="${keyword}" /></span></h5>
	</c:if>	
	
	<div class="container">
	 <div class="row">
	   <c:forEach var="project" items="${projects}" varStatus="status">
	    <div class="col-lg-4 col-md-6 mb-4">
	     <div class="card border-light mb-3" OnClick="location.href='<c:url value='/project/${project.projectId}' />'"> 
	      <div class="embed-responsive embed-responsive-4by3">
	      <c:choose>
	       <c:when test="${project.image eq 'default'}">
	        <img class="card-img-top embed-responsive-item" src="<c:url value='/images/default.jpg' />"/>
	       </c:when>
	       <c:otherwise>
	        <img class="card-img-top embed-responsive-item" src="<c:url value='/images/${project.image}' />">
	       </c:otherwise>
	      </c:choose>
	      </div>
	      <div class="card-body"> 
	       <h6 class="strong" style="height:35px;">${project.name}</h6>
	       <fmt:formatNumber value="${project.currentAmount}" pattern="#,###"/> 원
	       <small>${project.progress} % 달성</small>
	      </div> 
	     </div>
	    </div>
	   </c:forEach>
	 </div>
    </div>

</div>

<%@ include file="IncludeBottom.jsp"%>