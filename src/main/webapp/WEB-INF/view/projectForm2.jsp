<%@ include file="IncludeTop.jsp" %>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>

<div class="container" style="margin-top:40px">
	<h5 class="my-4">프로젝트 상품 구성</h5>
	<form:form modelAttribute="projectForm" method="post" action="done" enctype="multipart/form-data">
	
	<div class="card my-4" >
	 <div class="card-body">
	 	<c:if test="${not empty projectForm.products}">
			<h6 class="my-3">상품 리스트</h6>
			<div class="row">
				<c:forEach var="product" items="${projectForm.products}" varStatus="status">
					<div class="col-md-6 col-lg-3 mb-4">
					<div class="card">
					  <div class="card-body">
					  	<div class="inline-block" style="margin-bottom:10px;">
					  		<div class="small" style="float:left;">✓ ${product.member}명이 선택</div>
					  		<c:choose>
					  		 <c:when test="${product.quantity > 0}">
					  		  <span class="badge badge-danger" style="float:right;">${product.quantity}개 남음</span>
					  		 </c:when>
					  		 <c:when test="${product.quantity == 0}">
					  		  <span class="badge badge-secondary" style="float:right;">선착순 마감</span>
					  		 </c:when>
					  		</c:choose>
					  	</div>
						<h4 class="card-title py-2" style="clear:both;"><fmt:formatNumber value="${product.price}" pattern="#,###"/>원 + </h4>
						<div class="card-subtitle text-muted small" style="margin:10px 0px;">${product.name}</div>
						<small>${product.description}</small> <br />
					  </div>
					 </div>
					 </div>
				</c:forEach>
			</div>
			</c:if>
	
		<div style="float: right; margin-bottom:10px">
			<input type="button" class="btn btn-outline-primary" value="상품 추가하기" onclick="location.href='<c:url value='/editProject/productForm' />'"/> <br/>
		</div>
		
		<div class="form-group">
		<table class="table table-hover">
			<thead>
				<tr> <th scope="col">상품 이름</th> <th scope="col">최소 후원금액</th> <th scope="col">수량</th> <th scope="col"></th> </tr>
			</thead>
			<tbody>
			<c:forEach var="product" items="${projectForm.products}" varStatus="status">
				<tr>
					<td>${product.name}</td>
					<td><fmt:formatNumber value="${product.price}" pattern="#,###"/></td>
					<c:choose>
					  <c:when test="${product.quantity == -1}">
					    <td>제한없음</td>
					  </c:when>
					  <c:otherwise>
					    <td>${product.quantity}</td>
					  </c:otherwise>
					</c:choose>
					<td><a onclick="return validate(${product.member});" href="<c:url value='/newProject/deleteProduct/${product.productId}' />">삭제</a></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		</div>
		
	 </div>
	</div>
	
	<div class="inline-block">
		<input type="button" value="이전 단계로" class="btn btn-outline-secondary" onclick="location.href='<c:url value='/editProject/step1' />'">
		<input type="submit" class="btn btn-outline-primary" onclick="return confirm('프로젝트를 등록하시겠습니까?');" style="float:right;" value="프로젝트 등록" />
	</div>
	
	</form:form>
	
</div>

<script>
	function validate(member) {
		if(member > 0) {
			alert("상품을 선택한 후원자가 있어 삭제할 수 없습니다.");
			return false;
		}
		return true;
	}
</script>

<%@ include file="IncludeBottom.jsp"%>