<%@ include file="IncludeTop.jsp" %>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>

<div class="container" style="margin-top:20px">

	<h4 style="display:table; margin-top:30px; margin-bottom:30px; margin-left:auto; margin-right:auto;"> ${project.name}</h4>

	<form method="post">
	<div class="list-group" >
	 <a href="<c:url value='/support/step2' />" class="list-group-item list-group-item-action flex-column align-items-start">
		<h6 class="my-4"> 1,000 원 이상 후원해주시는 분께 </h6>
		<div class="my-4"> 상품을 선택하지 않는 옵션입니다. </div>
	 </a>
		
	 <c:forEach var="product" items="${project.products}" varStatus="status"> 	
	 	<c:choose>
		 <c:when test="${product.quantity == 0}"> 
			<a href="#" class="list-group-item list-group-item-action flex-column align-items-start disabled">
			 <h6 class="my-4"> <fmt:formatNumber value="${product.price}" pattern="#,###"/> 원 이상 후원해주시는 분께 </h6>	 
			 <div class="text-muted"> ${product.name} </div>
			 <div class="my-4"> ${product.description} </div>
			 <div class="small my-4"> ✓ ${product.member}명이 선택하였습니다. <font style="color: red;">선착순 마감</font> </div>
			</a>
		 </c:when>
		 <c:otherwise>
		 	<a href="<c:url value='/support/step2/${product.productId}?amount=${product.price}' />" class="list-group-item list-group-item-action flex-column align-items-start">
			 <h6 class="my-4"> <fmt:formatNumber value="${product.price}" pattern="#,###"/> 원 이상 후원해주시는 분께 </h6>	 
			 <div class="text-muted"> ${product.name} </div>
			 <div class="my-4"> ${product.description} </div>
			 <div class="small my-4"> ✓ ${product.member}명이 선택하였습니다. </div>
			</a>
		 </c:otherwise>
		</c:choose>
	 </c:forEach>
	</div>
	</form>

</div>

<%@ include file="IncludeBottom.jsp"%>