<%@ include file="IncludeTop.jsp" %>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>

<div class="container" style="margin-top:40px">
	<h5 class="my-4">프로젝트 개요</h5>
	<form:form modelAttribute="projectForm" method="post" action="step2" enctype="multipart/form-data">
	
	<div class="card my-4" >
	 <div class="card-body">
		<div class="form-group my-3">
		<label for="name">프로젝트 제목</label> <br />
		<form:input path="name" class="form-control" style="width:500px;"/>
		<form:errors path="name" class="form-text text-muted small"/> <br />
		</div>
		<hr style="margin-bottom:30px;"/>
		
		<div class="form-group my-3">
		<label for="image">프로젝트 이미지</label>
		<input type="file" name="image" class="form-control-file"/>
		<form:errors path="image" class="form-text text-muted small"/> <br />
		</div>
		<hr style="margin-bottom:30px;"/>
		
		<div class="form-group">
		<label for="category">프로젝트 카테고리</label>
		<form:select path="category" items="${categoryList}" class="form-control" style="width:200px;"/>
		<form:errors path="category" class="form-text text-muted small"/> <br />
		</div>
		<hr style="margin-bottom:30px;"/>
		
		<div class="form-group">
		<label for="goalAmount">목표 금액</label> <br />
		<form:input path="goalAmount" class="form-control" style="width:300px;"/>
		<form:errors path="goalAmount" class="form-text text-muted small"/> <br />
		</div>
		<hr style="margin-bottom:30px;"/>
		
		<div class="form-group">
		<label for="deadline">펀딩 마감일</label> <br />
		<form:input path="deadline" class="form-control" style="width:300px;"/>
		<form:errors path="deadline" class="form-text text-muted small"/> <br />
		</div>
		<hr style="margin-bottom:30px;"/>
		
		<div class="form-group">
		<label for="description">프로젝트 소개</label> <br />
		<form:textarea path="description" class="form-control" style="height:200px"/>
		<form:errors path="description" class="form-text text-muted small"/> <br />
		</div>
	 </div>
	</div>

	<input type="submit" class="btn btn-outline-primary" style="float:right;" value="다음 단계로" />
	
	</form:form>
</div>

<%@ include file="IncludeBottom.jsp"%>