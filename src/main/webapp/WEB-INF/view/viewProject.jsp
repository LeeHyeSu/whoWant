<%@ include file="IncludeTop.jsp" %>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>

<div class="container" style="margin-top:50px">

	<span class="badge badge-primary" style="display:table; margin-left:auto; margin-right:auto;">${project.category}</span>
	<h2 style="display:table; margin-top:30px; margin-bottom:50px; margin-left:auto; margin-right:auto;"> ${project.name}</h2>
	
	<div class="row" style="margin-top:30px; margin-bottom:50px">
	    <div class="col-xl-8 col-lg-8">
	      <c:choose>
	       <c:when test="${project.image eq 'default'}">
	       <div class="embed-responsive embed-responsive-4by3">
	        <img class="embed-responsive-item" src="<c:url value='/images/default.jpg' />" />
	       </div>
	       </c:when>
	       <c:otherwise>
	       <div class="embed-responsive embed-responsive-4by3">
	        <img class="embed-responsive-item" src="<c:url value='/images/${project.image}' />" alt="">
	       </div>
	       </c:otherwise>
	      </c:choose>
	    </div>
	
	    <div class="col-xl-4 col-lg-4 px-4 py-3">     
	     <div>
	            모인 금액
	      <h3 class="my-3"><fmt:formatNumber value="${project.currentAmount}" pattern="#,###"/> <small>원</small> </h3>   
	     </div>
	     <div>          
	            후원자
	      <h3 class="my-3"><fmt:formatNumber value="${project.supporterNum}" pattern="#,###"/> <small>명</small> </h3>
	     </div>
	     <div>
	            남은 시간
	      <c:choose>      
	       <c:when test="${project.daysUntilDeadline < 0}">
	      	<h3 class="my-3">0 <small>일</small> </h3>
	       </c:when>
	       <c:otherwise>
	        <h3 class="my-3">${project.daysUntilDeadline} <small>일</small> </h3>
	       </c:otherwise>
	      </c:choose>
	     </div>
	     
	     <div class="card bg-light my-4">
			  <div class="card-body">
			  <c:choose>
			  	<c:when test="${project.daysUntilDeadline < 0 && project.currentAmount >= project.goalAmount}">
			  		<div class="small mb-2"><strong>펀딩 성공</strong></div>
			  		<div class="small">
			    		목표 금액을 달성했습니다.
			    	</div>
			  	</c:when>
			  	<c:when test="${project.daysUntilDeadline < 0 && project.currentAmount < project.goalAmount}">
			  		<div class="small mb-2"><strong>펀딩 실패</strong></div>
			  		<div class="small">
			    		목표 금액을 달성하지 못했습니다.
			    	</div>
			  	</c:when>
			  	<c:otherwise>
			  		<div class="small mb-2"><strong>펀딩 진행중</strong></div>
			    	<div class="small">
			    		목표 금액  <strong><fmt:formatNumber value="${project.goalAmount}" pattern="#,###"/>원</strong> <br>
			    		펀딩 마감일  <strong>${project.deadline}</strong>
			    	</div>
			  		
			  	</c:otherwise>
			  </c:choose>
			  </div>
		</div>
    
	      <form>
			<input type="hidden" name="projectId" value="${project.projectId}">
			<c:choose>
			<c:when test="${!empty userSession.account && userSession.account.username == project.username}">
				<input type="hidden" name="project" value="${project.name}">
				<input type="submit" value="프로젝트 후원현황 " class="btn btn-block btn-outline-primary" style="margin-top:30px" formaction="<c:url value='/supports' />">
			</c:when>
			<c:when test="${project.daysUntilDeadline < 0}">
				<input type="submit" value="이미 마감된 프로젝트입니다"class="btn btn-block btn-secondary disabled" style="margin-top:30px">
			</c:when>
			<c:otherwise>
				<input type="submit" value="프로젝트 후원하기" class="btn btn-block btn-outline-primary" style="margin-top:30px" formaction="<c:url value='/support/step1' />"><br/>
			</c:otherwise>
			</c:choose>
		  </form> 
		 </div>
	</div>
	
	<ul class="nav nav-tabs">
		<li class="nav-item">
    		<a class="nav-link active" data-toggle="tab" href="#intro">프로젝트 소개</a>
  		</li>
  		<li class="nav-item">
    		<a class="nav-link" data-toggle="tab" href="#profile">만든이 소개</a>
  		</li>
  		<li class="nav-item">
    		<a class="nav-link" data-toggle="tab" href="#QnA">Q&A</a>
  		</li>
	</ul>
	
	<div id="myTabContent" class="tab-content">
		<div class="tab-pane fade active show" id="intro">
			<div class="row" style="margin-top:30px">
				<div class="col-xl-8 col-lg-8 mb-5">
					<div class="my-4">
						${project.description}
					</div>
				</div>
				
				<div class="col-xl-4 col-lg-4">
				<c:if test="${not empty project.products}">
				<h5 class="my-4">프로젝트에 포함된 상품</h5>
				  <c:forEach var="product" items="${project.products}" varStatus="status">
					<div class="card border-secondary mb-3">
					  <div class="card-body" style="margin-bottom:10px;">
					  	<div class="inline-block">
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
				   </c:forEach>
			     </c:if>
				</div>
			</div>
			
			
		</div>
		<div class="tab-pane fade" id="profile">
			<div style="margin:50px 0px">
				<h4 class="my-3">${creater.name}</h4>
				<small>${creater.intro}</small>
			</div>
			<hr>
			<h6 class="my-4">올린 프로젝트</h6>
			<div class="row">
			   <c:forEach var="project" items="${projects}" varStatus="status">
			    <div class="col-lg-4 col-sm-6">
			     <div class="card border-light mb-3" OnClick="location.href='<c:url value='/project/${project.projectId}' />'"> 
			      <div class="embed-responsive embed-responsive-4by3">
			       <c:choose>
			        <c:when test="${project.image eq 'default'}">
			        <img class="card-img-top embed-responsive-item" src="<c:url value='/images/default.jpg' />" class="card-img-top"/>
			        </c:when>
			        <c:otherwise>
			         <img class="card-img-top embed-responsive-item" src="<c:url value='/images/${project.image}' />" class="card-img-top" alt="">
			        </c:otherwise>
			       </c:choose>
			      </div>
			      <div class="card-body"> 
			       <h6 class="card-title" style="height:35px;">${project.name}</h6>
			       <fmt:formatNumber value="${project.currentAmount}" pattern="#,###"/> 원
			       <small>${project.progress} % 달성</small>
			       <div style="float: right;">
			        <span class="badge badge-light">
			       	<c:choose>
			         <c:when test="${project.daysUntilDeadline >= 0}">
			          	${project.daysUntilDeadline}일 남음
			         </c:when>
			         <c:when test="${project.daysUntilDeadline < 0 && project.progress >= 100}">
			          	펀딩 성공
			         </c:when>
			         <c:otherwise>
			         	펀딩 실패
			         </c:otherwise>
			       	</c:choose>
			       	</span>
			       </div>
			      </div> 
			     </div>
			    </div>
			   </c:forEach>
			 </div>
		</div>
		<div class="tab-pane fade" id="QnA">
			<div style="margin-top:30px">
				<h5 class="my-3">Q&A</h5>
				<small>프로젝트에 관해 궁금하신 점이나 판매자에게 문의할 사항이 있으신 경우 작성해주세요.</small>
			</div>
			<div style="float: right; margin:10px 0px;">
				<input type="button" value="프로젝트 문의하기" class="btn btn-outline-secondary" onclick="location.href='<c:url value='/inquiry?projectId=${project.projectId}' />'">
			</div>
			
			<table class="table table-hover">
				<thead>
				 <tr>
				  <th scope="col">분류</th>
				  <th scope="col">답변상태</th>
				  <th scope="col">제목</th>
				  <th scope="col">작성자</th>
				  <th scope="col">작성일</th>
				 </tr>
				</thead>
				<tbody>
				 <c:forEach var="inquiry" items="${inquiries}" varStatus="status">
				  <tr>
				  <td>${inquiry.category}</td>
				  <td>	
					<c:choose>
						<c:when test="${inquiry.isAnswer == '1'}">
							 답변완료
						</c:when>
						<c:when test="${inquiry.isAnswer == '0'}">
							 답변대기
						</c:when>
					</c:choose>
				  </td>
				  
				  <c:choose>
					  <c:when test="${inquiry.isSecret == '1' && userSession.account.username != inquiry.username
					  					&& userSession.account.username != project.username}">
					  	<td>🔒 비밀글입니다</td>
					  </c:when>
					  <c:otherwise>
					  	<td><a href="<c:url value='/viewInquiry?inquiryId=${inquiry.inquiryId}' />">${inquiry.title}</a></td>
					  </c:otherwise>
				  </c:choose>
				  
				  <td>${fn:substring(inquiry.username, 0, 3)}****</td>
				  <td>${inquiry.inqDate}</td>
			     </tr>
			     </c:forEach>
				</tbody>
			</table>
		</div>
	</div>

</div>

<%@ include file="IncludeBottom.jsp"%>