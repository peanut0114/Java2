<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:set var="user" value="${id}"/>
	<c:if test="${empty user}">
		<c:redirect url="memberLoginForm.do"></c:redirect>
	</c:if>
	<div id="container">
		<form action="insertBoard.do" method="post">
			<label>글제목</label><input type="text" name="title" autofocus required><br>
			<label>글내용</label><textarea name="content" required></textarea><br>
			<label>작성자</label>
				<input type="text" name="writer" value="${user}" readonly><br>
			<input type="submit" value="등록">
			<a href="boardList.jsp"><input type="button" value="취소"></a>
		</form>
	</div>
</body>
</html>