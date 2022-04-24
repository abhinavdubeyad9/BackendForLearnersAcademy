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
	<h1 class="heading">Student List</h1>
	<table class="student master center">
		<tr>
			<th>Roll NO.</th>
			<th>Name</th>
		</tr>
		<c:forEach var="tempStudent" items="${STUDENT_LIST }">
			<tr>
				<td>${tempStudent.id}</td>
				<td>${tempStudent.name}</td>
			</tr>
		</c:forEach>
	</table>


</body>
</html>