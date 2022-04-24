<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Learner's Academy</title>
<link href="./CSS/homePage.css" rel="stylesheet" type="text/css">
</head>
<body>
	<jsp:include page="Header.jsp" />
	<h1 class="heading">Welcome Admin !</h1>
	<c:url var="subjectsLink" value="AdminServlet">
		<c:param name="command" value="SUBJECTS" />
	</c:url>
	<c:url var="teachersLink" value="AdminServlet">
		<c:param name="command" value="TEACHERS" />
	</c:url>
	<c:url var="studentsLink" value="AdminServlet">
		<c:param name="command" value="STUDENTS" />
	</c:url>
	<c:url var="classesLink" value="AdminServlet">
		<c:param name="command" value="CLASSES" />
	</c:url>
	<div class="container">
		<button class="box" onclick="location.href ='${teachersLink}'">Teachers</button>
		<button class="box" onclick="location.href ='${studentsLink}'">Students</button>
		<button class="box" onclick="location.href ='${subjectsLink}'">Subjects</button>
		<button class="box" onclick="location.href ='${classesLink}'">Class
			Reports</button>

	</div>
</body>
</html>