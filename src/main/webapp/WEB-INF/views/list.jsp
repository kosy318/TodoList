<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
<jsp:include page="head.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="nav.jsp" />
	<div class="container text-center pt-5">
		<h1>${ user.name }'s Todo List</h1>
		<div class="text-right mb-2">
			<a href="insert" class="btn btn-info" role="button">할 일 추가</a>&nbsp;&nbsp;
			<a href="deleteAll" class="btn btn-info" role="button">전체 삭제</a>
		</div>
		<form class="form-inline mb-2 float-right" action="searchAll" method="get">
			<select class="form-control" name="search" id="search" onchange="selectChange()">
				<option value="content" selected="selected">내용</option>
				<option value="date">날짜</option>
			</select>&nbsp;&nbsp; <input id="word" class="form-control mr-sm-2" type="text"
				name="word">
			<button class="btn btn-info my-2 my-sm-0" type="submit">검색</button>
		</form>
		<br>

		<table class="table">
			<thead>
				<tr>
					<th>번호</th>
					<th>내용</th>
					<th>날짜</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach begin="1" end="${ fn:length(todoList) }" var="i">
					<tr>
						<td>${ fn:length(todoList) - i + 1 }</td>
						<c:if test="${ todoList[i-1].done eq 'N' }">
							<td><a href="read?num=${ todoList[i-1].num }">${ todoList[i-1].content }</a></td>
						</c:if>
						<c:if test="${ todoList[i-1].done eq 'Y' }">
							<td><a href="read?num=${ todoList[i-1].num }"><del>${ todoList[i-1].content }</del></a></td>
						</c:if>
						<td>${ todoList[i-1].sdate }~${ todoList[i-1].edate }</td>
						<c:if test="${ todoList[i-1].done eq 'N' }">
							<td><input
								onchange="window.location.href='change?done=${ todoList[i-1].done }&num=${ todoList[i-1].num }'"
								class="form-check-input" name="done" type="checkbox"></td>
						</c:if>
						<c:if test="${ todoList[i-1].done eq 'Y' }">
							<td><input
								onchange="window.location.href='change?done=${ todoList[i-1].done }&num=${ todoList[i-1].num }'"
								class="form-check-input" name="done" type="checkbox"
								checked="checked"></td>
						</c:if>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	<script>
		function selectChange(){
			select = document.querySelector("#search");
			if(select.value === "date"){
				document.querySelector("#word").setAttribute("type", "date");
			}else{
				document.querySelector("#word").setAttribute("type", "text");
			}
		}
	</script>
</body>
</html>



