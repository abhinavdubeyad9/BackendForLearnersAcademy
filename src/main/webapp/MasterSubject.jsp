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
	<h1 class="heading">Subject List</h1>
	<table class="master center">
		<tr>
			<th>Subject code</th>
			<th>Name</th>
			<th>Level</th>
		</tr>
		<c:forEach var="tempSubject" items="${SUBJECTS_LIST}">
			<tr>
				<td>${tempSubject.id}</td>
				<td>${tempSubject.name}</td>
				<td>${tempSubject.level}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>