<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>whoWant</title>

<!-- 	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css"> -->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootswatch/4.5.2/litera/bootstrap.min.css" integrity="sha384-enpDwFISL6M3ZGZ50Tjo8m65q06uLVnyvkFO3rsoW0UC15ATBFz3QEhr3hmxpYsn" crossorigin="anonymous">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
  
  	<link rel="stylesheet" href="css/bootstrap-table-expandable.css">
  	<script src="js/bootstrap-table-expandable.js"></script>
	<style type="text/css">
	
	 body, p {font-family: 나눔고딕;}
	 
	</style>
  </head>
  <body>
  <nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container">
  <a class="navbar-brand" href="<c:url value='/index' />">whoWant</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor03" aria-controls="navbarColor03" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarColor03">
    <ul class="navbar-nav mr-auto">
     <li class="nav-item">
      <a class="nav-link" href="<c:url value='/categoryList' />">프로젝트 둘러보기</a>
     </li>
     <li class="nav-item">
      <a class="nav-link" href="<c:url value='/newProject/step1' />">프로젝트 올리기</a>
     </li>
     <c:choose>
      <c:when test="${empty userSession.account}">
     	<li class="nav-item">
     	 <a class="nav-link" href="<c:url value='/login' />">로그인</a>
    	</li>
     	<li class="nav-item">
      	 <a class="nav-link" href="<c:url value='/newAccount' />">회원가입</a>
     	</li>
      </c:when>
      <c:when test="${!empty userSession.account}">
      	<li class="nav-item">
     	 <a class="nav-link" onclick="return confirm('로그아웃하시겠습니까?')" href="<c:url value="/logout" />">로그아웃</a>
    	</li>
     	<li class="nav-item dropdown">
     	 <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">마이페이지</a>
      	 <div class="dropdown-menu" style="">
      	 <a class="dropdown-item" href="<c:url value='/editAccount' />">내 정보조회</a>
      	 <a class="dropdown-item" href="<c:url value='/myProjects' />">내가 만든 프로젝트 </a>
      	 <a class="dropdown-item" href="<c:url value='/mySupports' />">내 후원현황</a>
      	 </div>
     	</li>
      </c:when>
     </c:choose>
    </ul>
    <form class="form-inline my-2 my-lg-0" name="search" action='<c:url value="/search"/>' onsubmit="return validate();" method="post">
      <input class="form-control mr-sm-2" type="text" name="keyword"  placeholder="키워드를 입력하세요">
      <button type="submit" class="btn btn-outline-primary">검색</button>
    </form>
  </div>
  </div>
  </nav>

  <script>
  function validate() {
		var form = document.search;
		var keyword = form.keyword.value;

		if(!keyword) {
			return false;
		}
		return true;
  }
  </script> 