<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>새 프로젝트 등록 완료</title>
</head>
<body>
${project.name} 프로젝트가 등록되었습니다.<p />

<p><a href="<c:url value='/projectList' />">프로젝트 리스트 조회</a></p>
</body>
</html>
