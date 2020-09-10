<%@ include file="IncludeTop.jsp" %>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>

<div class="container" style="margin-top:40px">
	<h5 class="my-4">상품 만들기</h5>
	<form:form modelAttribute="productForm" method="post">
	
	<div class="card my-4" >
	 <div class="card-body">
	 	<label>최소 후원금액</label>
		<div class="form-group form-inline">
		<form:input path="price" class="form-control" style="margin-right:10px; text-align:right;"/> 
		<label class="small">원 이상 후원해주시는 분께 드리는 상품입니다. </label> <br />
		<form:errors path="price" class="form-text text-muted small"/> <br />
		</div>
		<hr style="margin:30px 0px;"/>
		
		<div class="form-group">
		<label>상품 이름</label> <br />
		<form:input path="name" class="form-control" style="width:500px;"/>
		<form:errors path="name" class="form-text text-muted small" /> <br />
		</div>
		<hr style="margin-bottom:30px;"/>
		
		<div class="form-group">
		<label>상품 소개</label> <br />
		<form:textarea path="description" class="form-control" style="height:150px;"/>
		<form:errors path="description" class="form-text text-muted small" /> <br />
		</div>
		<hr style="margin-bottom:30px;"/>
		
		<div class="form-group form-inline">
		<label class="small">상품을 </label> 
		<form:input path="quantity" class="form-control" style="margin:0px 10px; width:80px;" />
		<label class="small">개로 제한합니다.</label> 
		<form:errors path="quantity" class="form-text text-muted small" /> <br />
		</div>
	 </div>
	</div>
	
	<div class="inline-block">
		<input type="button" value="이전 단계로" class="btn btn-outline-secondary" onclick="location.href='<c:url value='/editProject/step2' />'">
		<input type="submit" class="btn btn-outline-primary" style="float:right;" value="상품 등록" formaction="addProduct" />
	</div>
	</form:form>
</div>

<%@ include file="IncludeBottom.jsp"%>