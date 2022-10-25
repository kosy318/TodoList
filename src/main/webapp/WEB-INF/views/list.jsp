<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<jsp:include page="head.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="nav.jsp" />
	<div class="container text-center pt-5">
		<h1>Todo List</h1>
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
					<th>아이디</th>
					<th>날짜</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ todoList }" var="todo">
					<tr>
						<td>${ todo.num }</td>
						<c:if test="${ todo.done eq 'N' }">
							<td><a href="read?num=${ todo.num }">${ todo.content }</a></td>
						</c:if>
						<c:if test="${ todo.done eq 'Y' }">
							<td><a href="read?num=${ todo.num }"><del>${ todo.content }</del></a></td>
						</c:if>
						<td>${ todo.id }</td>
						<td>${ todo.sdate }~${ todo.edate }</td>
						<c:if test="${ todo.done eq 'N' }">
							<td><input
								onchange="window.location.href='change?done=${ todo.done }&num=${ todo.num }'"
								class="form-check-input" name="done" type="checkbox"></td>
						</c:if>
						<c:if test="${ todo.done eq 'Y' }">
							<td><input
								onchange="window.location.href='change?done=${ todo.done }&num=${ todo.num }'"
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



