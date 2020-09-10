<%@ include file="IncludeTop.jsp" %>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>

<div class="container" style="margin-top:20px">
	<div class="col-lg-6 mx-auto">
	 <div class="card my-4" >
	  <div class="card-body">
		<h4 class="card-title my-4">창작자에게 문의하기</h4>
		
		<form name="inquiryForm" action='<c:url value="/inquiry"/>' onsubmit="return validate();" method="post">
		
		<div class="form-group">
			<label for="title">제목 </label>
			<input type="text" class="form-control" id="title" name="title" />
		</div>
		
		<div class="form-group">
			<label for="category">문의 유형</label>
			<select name="category" id="category" class="custom-select">
			 <option value="">문의 유형</option>
			 <option value="프로젝트">프로젝트</option>
			 <option value="후원">후원</option>
			 <option value="교환/환불">교환/환불</option>
			 <option value="배송">배송</option>
			 <option value="기타">기타</option>
			</select>
		</div>
		
		<div class="form-group">
			<label for="question">문의 내용</label>
			<textarea name="question" id="question" class="form-control" cols="50" rows="10"></textarea>
		</div>
		
		<div class="form-group">
			<div class="custom-control custom-checkbox">
      			<input type="checkbox" class="custom-control-input" id="customCheck1" name="isSecret" value="1">
      			<input type="hidden" name="isSecret" value="0">
      			<label class="custom-control-label" for="customCheck1">비공개</label>
    		</div>
	    </div>
		
		<input type="submit" class="btn btn-outline-primary" style="float:right; padding:5px 50px" value="등록" />
		
		</form>
	  </div>
	 </div>
	</div>
</div>

<script>
	function validate() {
		var form = document.inquiryForm;
		var title = form.title.value;
		var category = form.category.value;
		var question = form.question.value;

		if(!title) {
			alert("문의 제목을 입력해주세요.");
			return false;
		} else if(!category) {
			alert("문의 카테고리를 선택해주세요.");
			return false;
		} else if(!question) {
			alert("문의 내용을 입력해주세요.");
			return false;
		}

		return true;
	}
</script>

<%@ include file="IncludeBottom.jsp"%>