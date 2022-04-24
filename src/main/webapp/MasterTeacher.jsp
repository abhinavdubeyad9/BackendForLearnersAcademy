<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Learners Academy</title>
<link href="./CSS/master.css" rel="stylesheet" type="text/css">
</head>
<body>
	<jsp:include page="Header.jsp" />
	<h1 class="heading">Teacher List</h1>
	<table class="master center">
		<tr>
			<th>Emp Id</th>
			<th>Name</th>
			<th>Years of Exp</th>
			<th>Expert at</th>
		</tr>
		<c:forEach var="tempTeacher" items="${TEACHERS_LIST }">
			<tr>
				<td>${tempTeacher.id}</td>
				<td>${tempTeacher.name}</td>
				<td>${tempTeacher.experience}</td>
				<td>${tempTeacher.expertise}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>