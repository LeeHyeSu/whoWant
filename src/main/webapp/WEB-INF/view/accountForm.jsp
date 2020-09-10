<%@ include file="IncludeTop.jsp" %>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>

<div class="container" style="margin-top:20px">
	<div class="row">
      <div class="col-lg-6 col-md-8  mx-auto">
        <div class="card card-signin my-5">
          <div class="card-body">
			<c:choose>
			<c:when test="${empty userSession.account}">
				<h3 class="card-title text-center my-4">회원가입</h3>
			</c:when>
		    <c:when test="${!empty userSession.account}">
		    	<h3 class="card-title text-center my-4">내 정보조회</h3>
			</c:when>
			</c:choose>
			<form:form name="account" modelAttribute="accountForm" method="post" >
				<div class="form-group row my-4" >
					<label for="username" class="col-sm-4 col-form-label">아이디 </label>
					<div class="col-sm-8">
						<form:input path="username" class="form-control" />
						<form:errors path="username" class="form-text text-muted small"/>
					</div>
				</div>
					
				<div class="form-group row my-4">
					<label for="passwd" class="col-sm-4 col-form-label">비밀번호 </label>
					<div class="col-sm-8">
						<form:password path="passwd" class="form-control"/>
						<form:errors path="passwd" class="form-text text-muted small"/>
					</div>
				</div>
				
				<div class="form-group row my-4">
					<label for="name" class="col-sm-4 col-form-label">이름 </label>
					<div class="col-sm-8">
						<form:input path="name" class="form-control"/>
						<form:errors path="name" class="form-text text-muted small"/>
					</div>
				</div>
				
				<div class="form-group row my-4">
				 	<label for="phoneNum" class="col-sm-4 col-form-label">전화번호 </label>
				 	<div class="col-sm-8">
				 		<form:input path="phoneNum" class="form-control"/>
				 		<form:errors path="phoneNum" class="form-text text-muted small"/>
				 	</div>
				</div>
				
				<div class="form-group my-4">
					 <label for="postcode">주소 </label>
					 <div class="form-inline my-2 my-lg-0">
						 <form:input path="postcode" id="postcode" class="form-control mr-sm-2" placeholder="우편번호"/>
						 <input type="button" class="btn btn-outline-primary mt-2" onclick="execDaumPostcode()" value="우편번호 찾기"><br>
					 	<form:errors path="postcode" class="form-text text-muted small"/>
					 </div>
					 <form:input path="address" id="address" class="form-control my-3" placeholder="주소"/>
					 <form:errors path="address" class="form-text text-muted small"/>
					 <form:input path="detailAddress" id="detailAddress" class="form-control my-3" placeholder="상세주소"/>
					 <form:errors path="detailAddress" class="form-text text-muted small"/>
				</div>
				
				<div class="form-group my-4">
				  <label for="intro">자기 소개 </label>
				  <form:textarea path="intro" class="form-control" cols="50" row="4"/>
				  <form:errors path="intro"/>
				</div>
				
				<c:choose>
				<c:when test="${empty userSession.account}">
					<input type="submit" class="btn btn-block btn-outline-primary my-2" value="회원가입" formaction="/whoWant/newAccount"/>
					<div class="text-center">
                		<small>이미 계정이 있으신가요? <a href="<c:url value='/login' />">로그인</a></small>
                	</div>
				</c:when>
		   		<c:when test="${!empty userSession.account}">
		   			<div class="inline-block my-2">
		    			<input type="submit" class="btn btn-outline-secondary" value="탈퇴하기" onclick="return confirm('탈퇴하시겠습니까?');" formaction="/whoWant/withdraw"/>
						<input type="submit" class="btn btn-outline-primary" value="수정하기" onclick="return confirm('수정하시겠습니까?');" formaction="/whoWant/editAccount" style="float:right;"/>
					</div>
				</c:when>
				</c:choose>
				</form:form>
			</div>
		</div>
	  </div>
	</div>
</div>

<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    function execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById("postcode").value = data.zonecode;
                document.getElementById("address").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("detailAddress").focus();
            }
        }).open();
    }
</script>

<%@ include file="IncludeBottom.jsp"%>