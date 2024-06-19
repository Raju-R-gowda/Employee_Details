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
<%Integer r2=(Integer)request.getAttribute("abc"); %>
 id:<%= r2 %>is deleted;
 <h2>Employee Details</h2>
	<table border="1">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Age</th>
		</tr>
		<c:forEach var="mm" items="${xyz}">
			<tr>
				<td>${mm.id}</td>
				<td>${mm.name }</td>
				<td>${mm.age }</td>
			</tr>
		</c:forEach>
 
<br><br><br>
</body>
</html>