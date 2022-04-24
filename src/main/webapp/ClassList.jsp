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
	<h1 class="heading">Class List</h1>
	<table class="master center">
		<tr>
			<th>S no.</th>
			<th>Name</th>
			<th>Report</th>
		</tr>
		<c:forEach var="tempClass" items="${CLASS_LIST}">
			<tr>
				<c:url var="tempLink" value="AdminServlet">
					<c:param name="command" value="CLASS_REPORT" />
					<c:param name="classId" value="${tempClass.id }" />
					<c:param name="name" value="${tempClass.name}" />
					<c:param name="time" value="${tempClass.time }" />
					<c:param name="subject" value="${tempClass.subjectName}" />
					<c:param name="teacher" value="${tempClass.teacherName }" />
				</c:url>
				<td>${tempClass.id}</td>
				<td>${tempClass.name}</td>
				<td><a href="${tempLink }">click here</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>