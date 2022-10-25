<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>todoList</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<jsp:include page="nav.jsp" />
	<div class="container text-center pt-5">
		<h1>NOTICE</h1>
		<div class="text-right">
			<c:if test="${ role ne 'admin' }"><a href="notice-insert" class="btn btn-info" role="button">글쓰기</a></c:if>
		</div>
		<br>

		<table class="table">
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>날짜</th>
					<th>조회수</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ noticeList }" var="notice">
					<tr>
						<td>${ notice.num }</td>
						<td><a href="notice-read?num=${ notice.num }">${ notice.title }</a></td>
						<td>${ notice.regdate }</td>
						<td>${ notice.count }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>



