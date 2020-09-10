<%@ include file="IncludeTop.jsp" %>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>

<div class="container" style="margin-top:20px">

	<div class="card my-4" >
	  <div class="card-body m-3">
		<h3 class="card-title my-2">Q.</h3>
	
		<form action='<c:url value="/answer"/>' method="post">
			<div class="form-group row">
				<label for="inqDate" class="col-sm-2 col-form-label">작성일 </label>
				<div class="col-sm-10">
					<input type="text" readonly="" class="form-control-plaintext" value="${inquiry.inqDate}" />
				</div>
			</div>
			
			<div class="form-group row">
				<label for="inqUsername" class="col-sm-2 col-form-label">작성자 </label>
				<div class="col-sm-10">
					<input type="text" readonly="" class="form-control-plaintext" value="${inquiry.username}" />
				</div>
			</div>
		
			<div class="form-group row">
				<label for="title" class="col-sm-2 col-form-label">제목 </label>
				<div class="col-sm-10">
					<input type="text" readonly="" class="form-control-plaintext" value="${inquiry.title}" />
				</div>
			</div>
			
			<div class="form-group row">
				<label for="category" class="col-sm-2 col-form-label">문의 유형 </label>
				<div class="col-sm-10">
					<input type="text" readonly="" class="form-control-plaintext" value="${inquiry.category}" />
				</div>
			</div>
			
			<div class="form-group row">
				<label for="question" class="col-sm-2 col-form-label">문의 내용</label>
				<div class="col-sm-10">
					<input type="text" readonly="" class="form-control-plaintext" value="${inquiry.question}" />
				</div>
			</div>
		
		
		<c:if test="${userSession.account.username == project.username && inquiry.isAnswer == '0'}">
			<textarea name="answer" class="form-control" cols="50" rows="10"></textarea>
			<div style="float: right; margin:10px 0px;">
				<input type="submit" value="답변하기" class="btn btn-outline-primary" formaction="<c:url value='/answer?inquiryId=${inquiry.inquiryId}' />">
			</div>
		</c:if>
		
		<c:if test="${!empty answer}">
			<hr class="my-4"/>
			<h3 class="my-2">A.</h3>
			<div class="form-group row">
				<label for="ansDate" class="col-sm-2 col-form-label">답변일</label>
				<div class="col-sm-10">
					<input type="text" readonly="" class="form-control-plaintext" value="${answer.ansDate}" />
				</div>
			</div>
			
			<div class="form-group row">
				<label for="answer" class="col-sm-2 col-form-label">답변 내용</label>
				<div class="col-sm-10">
					<input type="text" readonly="" class="form-control-plaintext" value="${answer.answer}" />
				</div>
			</div>
		</c:if>
		</form>
	 </div>
	</div>
	
</div>

<%@ include file="IncludeBottom.jsp"%>