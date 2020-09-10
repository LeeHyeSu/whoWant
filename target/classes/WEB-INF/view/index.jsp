<%@ include file="IncludeTop.jsp" %>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
 
<div style="background:transparent !important" class="jumbotron text-center">
  <div class="container">
   <h1 class="display-3">WHO WANT ?</h1>
   <p class="my-3">크라우드펀딩으로 프로젝트를 위한 자금을 모으고, 든든한 후원자 네트워크를 확보하세요.</p>
   <button class="btn btn-outline-primary my-3 px-5" OnClick="location.href='<c:url value='/newProject/step1' />'">지금 시작하기</button>
  </div>
</div>
  
<div class="container">
   <h5 class="my-4">모든 프로젝트</h5>
   <div class="row">
    <c:forEach var="project" items="${projects}" varStatus="status">
    <div class="col-lg-3 col-sm-6">
     <div class="card border-light mb-3" OnClick="location.href='<c:url value='/project/${project.projectId}' />'"> 
      <div class="embed-responsive embed-responsive-4by3">
       <c:choose>
	       <c:when test="${project.image eq 'default'}">
	        <img class="card-img-top embed-responsive-item" src="<c:url value='/images/default.jpg' />"/>
	       </c:when>
	       <c:otherwise>
	        <img class="card-img-top embed-responsive-item" src="<c:url value='/images/${project.image}' />">
	       </c:otherwise>
	      </c:choose>
      </div>
      <div class="card-body"> 
       <h6 class="card-title" style="height:50px">${project.name}</h6>
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
   
   <button class="btn btn-outline-primary my-4 px-5" onclick="location.href='<c:url value='/allProjects' />'" style="display:table; margin-left:auto; margin-right:auto;">모든 프로젝트 더보기</button>
</div>

<div class="jumbotron text-center mt-5 mb-0">
	<p class="lead small">프로젝트의 완수 및 선물제공의 책임은 해당 프로젝트의 창작자에게 있으며, 
	프로젝트와 관련하여 후원자와 발생하는 법적 분쟁에 대한 책임은 해당 창작자가 부담합니다.</p>
</div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
</body>
</html>

