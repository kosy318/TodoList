<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>���� ������</title>
</head>
<body>
	<h1>���� ������</h1>
	<c:if test="${!empty errormsg}">
		${errormsg}
	</c:if>
	<a href="list">�ʱ�ȭ��</a>
</body>
</html>