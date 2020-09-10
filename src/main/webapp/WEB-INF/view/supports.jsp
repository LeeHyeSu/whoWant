<%@ include file="IncludeTop.jsp" %>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>

<div class="container" style="margin-top:20px">

	<h4 class="my-5">${project} 프로젝트 후원 현황</h4>
	
	<table class="table table-hover">
		<thead>
			<tr>
				<th scope="col">회원 이름</th>
				<th scope="col">후원 금액</th>
				<th scope="col">후원 날짜</th>
				<th scope="col">결제 방법</th>
				<th scope="col"></th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="support" items="${supports}" varStatus="status">
			<tr>
				<td>${support.supporterName}</td>
				<td><fmt:formatNumber value="${support.amount}" pattern="#,###"/></td>
				<td>${support.supportDate}</td>
				<td>${support.paymentOption}</td>
				<td><a data-toggle="modal" href="#detail">상세보기</a></td>
			</tr>
			
			<!-- Modal -->
			<div class="modal fade" id="detail" tabindex="-1" role="dialog" aria-hidden="true">
			  <div class="modal-dialog">
			    <div class="modal-content">
			      <div class="modal-header">
			      	<h6 class="modal-title">${support.supporterName}님의 후원</h6>
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			      </div>
			      <div class="modal-body m-1">
			        <div>
			        	<div class="form-group row">
			        		<label for="username" class="col-sm-3 col-form-label">아이디 </label>
			        		<div class="col-sm-8">
								<input type="text" readonly="" class="form-control-plaintext" value="${support.username }" />
							</div>
			        	</div>
			        	<div class="form-group row">
			        		<label for="productName" class="col-sm-3 col-form-label">선택한 상품 </label>
			        		<div class="col-sm-8">
								<input type="text" readonly="" class="form-control-plaintext" value="${support.productName }" />
							</div>
			        	</div>
			        	<div class="form-group row">
			        		<label for="amount" class="col-sm-3 col-form-label">후원 금액 </label>
			        		<div class="col-sm-8">
								<input type="text" readonly="" class="form-control-plaintext" value="${support.amount }" />
							</div>
			        	</div>
			        	<div class="form-group row">
			        		<label for="supportDate" class="col-sm-3 col-form-label">후원 날짜 </label>
			        		<div class="col-sm-8">
								<input type="text" readonly="" class="form-control-plaintext" value="${support.supportDate }" />
							</div>
			        	</div>
			        	<div class="form-group row">
			        		<label for="paymentOption" class="col-sm-3 col-form-label">결제 방법 </label>
			        		<div class="col-sm-8">
								<input type="text" readonly="" class="form-control-plaintext" value="${support.paymentOption }" />
							</div>
			        	</div>
			        	<div class="form-group row">
			        		<label for="amount" class="col-sm-3 col-form-label">전화번호  </label>
			        		<div class="col-sm-8">
								<input type="text" readonly="" class="form-control-plaintext" value="${support.phonenum }" />
							</div>
			        	</div>
			        	<div class="form-group row">
			        		<label for="shipAddress" class="col-sm-3 col-form-label">주소  </label>
			        		<div class="col-sm-8">
								<input type="text" readonly="" class="form-control-plaintext" value="${support.shipAddress }" />
							</div>
			        	</div>
			        	<div class="form-group row">
			        		<label for="request" class="col-sm-3 col-form-label">요청사항 </label>
			        		<div class="col-sm-8">
								<input type="text" readonly="" class="form-control-plaintext" value="${support.request }" />
							</div>
			        	</div>
			        </div>
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-outline-default" data-dismiss="modal">닫기</button>
			      </div>
			    </div>
			  </div>
			</div>
		</c:forEach>
		</tbody>
	</table>

</div>



<%@ include file="IncludeBottom.jsp"%>