<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<title>whoWant-register</title>
</head>
<body>
	<h2>회원가입</h2>
	<form:form modelAttribute="regReq" method="post" action="main">
		<label for="username">이름 </label>
		<form:input path="username"/>
		<form:errors path="username"/><br/>
		
		<label for="nickname">아이디 </label>
		<form:input path="nickname"/>
		<form:errors path="nickname"/><br/>
		
		<label for="passwd">비밀번호 </label>
		<form:password path="passwd"/>
		<form:errors path="passwd"/><br/>
		
		<label for="passwdCheck">비밀번호 확인 </label>
		<form:password path="passwdCheck"/>
		<form:errors path="passwdCheck"/>
		<form:errors path="samePasswordConfirmPassword"/><br/>
		
		<label for="phonenum">전화 번호 </label>
		<form:input path="phonenum"/>
		<form:errors path="phonenum"/>&nbsp;
		
		<label for="addr1">우편번호 </label>
		<form:input path="addr1"/>
		<form:errors path="addr1"/><br/>
		
		<label for="addr2">도로명 주소 </label>
		<form:input path="addr2"/>
		<form:errors path="addr2"/><br/>
		
		<label for="addr3">상세 주소 </label>
		<form:input path="addr3"/>
		<form:errors path="addr3"/><br/>
		
		<label for="intro">자기 소개 </label>
		<form:textarea path="intro" cols="4"/>
		<form:errors path="intro"/><br/>
		
		<input type="submit" value="회원 가입"/>
	</form:form>
</body>
</html>