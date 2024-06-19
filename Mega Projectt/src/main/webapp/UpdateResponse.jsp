<%@ page import="com.employeemodel.www.EmployDetailss" %>
<%@page import="java.util.List" %>
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

<% String r1=(String)request.getAttribute("ui"); %>
result:<b> <%= r1 %></b>

<h2>Employee Details</h2>
	<table border="1">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Age</th>
		</tr>
		<c:forEach var="mm" items="${aii}">
			<tr>
				<td>${mm.id}</td>
				<td>${mm.name}</td>
				<td>${mm.age}</td>
			</tr>
		</c:forEach>

</table>
<br><br>
</body>
</html>