<%@ include file="IncludeTop.jsp" %>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>

<div class="container" style="margin-top:20px">
	<div class="row">
      <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
        <div class="card card-signin my-5">
          <div class="card-body">
            <h3 class="card-title text-center my-3">로그인</h3>
			<form action='<c:url value="/login"/>' method="post">
				<fieldset>
				<c:if test="${!empty forwardAction}">
			      	<input type="hidden" name="forwardAction"
			        	value='<c:url value="${forwardAction}"/>' />
			    </c:if>
			    
			    <div class="form-label-group">
			    	<label for="username">아이디 </label>
					<input type="text" class="form-control" name="username"/> <br/>
				</div>
				<div class="form-label-group">
					<label for="password">비밀번호 </label>
					<input type="password" class="form-control" name="password"/> <br/>
				</div>
				
				<input type="submit" class="btn btn-outline-primary btn-block my-2" value="로그인"/>
				<div class="text-center">
					<c:if test="${!empty message}">
			 		 <small><c:url value="${message}" /></small><br />
					</c:if>	
                	<small>아직 계정이 없으신가요? <a href="<c:url value='/newAccount' />">회원가입</a></small>
                </div>
				</fieldset>
			</form>
		   </div>
		 </div>
		</div>
	 </div>
</div>

<%@ include file="IncludeBottom.jsp"%>

