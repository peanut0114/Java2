<%@page import="co.edu.vo.BoardVO"%>
<%@page import="co.edu.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardDetail.jsp</title>
<link href="../css/table2.css" rel="stylesheet">
</head>
<body>
		<p>${board.seq }. 제목 : ${board.title }</p>
		<p>내용 : ${board.content }</p>
</body>
</html>