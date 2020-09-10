<%@ include file="IncludeTop.jsp" %>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>

<div class="container" style="margin-top:20px">

	<h4 style="display:table; margin-top:30px; margin-bottom:30px; margin-left:auto; margin-right:auto;"> ${project.name}</h4>
	
	<div class="col-lg-8 mx-auto">
	 <div class="card my-4" >
	  <div class="card-body">
	
		<form name="supportForm" method="post" action="/whoWant/support/done">
		
		<c:if test="${!empty product.name}">
		<div class="inline-block">
			선택한 상품
			<div style="float:right;"><b>${product.name}(<fmt:formatNumber value="${amount }" pattern="#,###"/>원)</b></div>
		</div>
		<hr />
		</c:if>
		
		<div class="form-inline">
			<label for="amount">후원 금액</label>
			<input type="text" class="form-control col-xs-2 ml-auto" name="amount" value="${amount }" style="text-align:right;"/>
		</div>
		<div class="small text-right my-2">최소 <fmt:formatNumber value="${amount }" pattern="#,###"/> 원부터 더 많은 금액을 후원하실 수 있습니다.</div>
		<hr style="margin-bottom:30px;"/>
		
		<div class="form-inline">
			<label for="request">요청사항</label>
			<input type="text" class="form-control col-sm-10 ml-auto" name="request" placeholder="선택하신 상품 및 후원에 대한 요청사항을 입력해주세요"/>
		</div>
		<hr style="margin:30px 0px;"/>
		
		
		<h5 class="my-4">후원자 정보 확인</h5>
		<div class="form-group row">
			<label class="col-sm-4 col-form-label">이름 </label>
			<div class="col-sm-8">
				<input type="text" readonly="" class="form-control-plaintext" value="${userSession.account.name }" />
			</div>
		</div>
		<div class="form-group row">
			<label class="col-sm-4 col-form-label">휴대폰 번호 </label>
			<div class="col-sm-8">
				<input type="text" readonly="" class="form-control-plaintext" value="${userSession.account.phonenum }" />
			</div>
		</div>
		<div style="float: right; margin-bottom:20px">
			<input type="button" class="btn btn-outline-primary" value="내 정보 변경하러가기" onclick="location.href='<c:url value='/editAccount' />'"/> <br/>
		</div>
		
		<hr style="clear:both; margin-bottom:30px"/>
		
		<h5 class="my-4">배송지 확인</h5>
		<div class="form-group row">
			<label class="col-sm-4 col-form-label">우편 번호 </label>
			<div class="col-sm-8">
				<input type="text" readonly="" class="form-control-plaintext" value="${userSession.account.postcode }" />
			</div>
		</div>
		<div class="form-group row">
			<label class="col-sm-4 col-form-label">도로명 주소 </label>
			<div class="col-sm-8">
				<input type="text" readonly="" class="form-control-plaintext" value="${userSession.account.address }" />
			</div>
		</div>
		<div class="form-group row">
			<label class="col-sm-4 col-form-label">상세 주소 </label>
			<div class="col-sm-8">
				<input type="text" readonly="" class="form-control-plaintext" value="${userSession.account.detailAddress }" />
			</div>
		</div>
		<div style="float: right; margin-bottom:20px">
			<input type="button" class="btn btn-outline-primary" value="주소 변경하러가기" onclick="location.href='<c:url value='/editAccount' />'"/> <br/>
		</div>
		
		<hr style="clear:both; margin-bottom:20px"/>
		
		<div class="form-group form-inline">
			<label for="paymentOption">결제 수단</label>
			<select class="form-control" name="paymentOption" style="margin:0px 10px;">
				<option>신용/체크카드</option>
				<option>네이버페이</option>
			</select><br/>
		</div>
		
		<div class="text-center">
			<input type="submit" class="btn btn-outline-primary" onclick="return validate(${amount});" style="margin-top:30px; padding:10px 50px" value="후원하기" />
		</div>

		</form>
			
	  </div>
	 </div>
	</div>

</div>

<script>
	function validate(amount) {
		var form = document.supportForm;
		var total_amount = form.amount.value;
		
		if(total_amount < amount) {
			alert("선택한 상품의 금액보다 큰 금액을 입력해주세요.");
			return false;
		}
		return true;
	}
</script>

<%@ include file="IncludeBottom.jsp"%>