<%@ page import="com.employeemodel.www.EmployDetailss" %>
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


id:<%=request.getAttribute("ban") %>
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



</body>
</html>