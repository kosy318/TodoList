<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${ id eq null }">
	<c:redirect url="login"/>
</c:if>
<c:if test="${ id ne null }"><c:redirect url="list"/></c:if>
</body>
</html>