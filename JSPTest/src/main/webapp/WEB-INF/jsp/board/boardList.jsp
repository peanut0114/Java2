<%@page import="co.edu.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@page import="co.edu.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardList.jsp</title>
<style>
.center {
	text-align: center;
}

.pagination {
	display: inline-block;
}

.pagination a {
	color: black;
	float: left;
	padding: 8px 16px;
	text-decoration: none;
	transition: background-color .3s;
	border: 1px solid #ddd;
	margin: 0 4px;
}

.pagination a.active {
	background-color: #4CAF50;
	color: white;
	border: 1px solid #4CAF50;
}

.pagination a:hover:not(.active) {
	background-color: #ddd;
}
</style>
</head>
<body>

	<table border='1'>
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일자</th>
				<th>방문횟수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="vo" items="${list}">
				<tr>
					<td><a href="boardDetail.do?id=${vo.seq}">${vo.seq}</a></td>
					<td>${vo.title}</td>
					<td>${vo.writer}</td>
					<td>${vo.date}</td>
					<td>${vo.visitCnt}</td>
				</tr>

			</c:forEach>
		</tbody>
	</table>
	<a href="addBoard.do"><input type="button" value="새 글 등록"></a>

	<div class="center">
		<div class="pagination">
		<c:if test="${pageInfo.prev }">
			<a href="boardListPaging.do?pageNum=${pageInfo.startPage-1}&amount=${pageInfo.cri.amount}"><</a> 
		</c:if>
			<c:forEach var="num" begin="${pageInfo.startPage}" end="${pageInfo.endPage}">
				<a href="boardListPaging.do?pageNum=${num}&amount=${pageInfo.cri.amount}">${num}</a> 
			</c:forEach>
		<c:if test="${pageInfo.next }">
			<a href="boardListPaging.do?pageNum=${pageInfo.endPage+1}&amount=${pageInfo.cri.amount}">></a>
		</c:if>
		</div>
	</div>

</body>
</html>