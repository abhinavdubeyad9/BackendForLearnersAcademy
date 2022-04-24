<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Learner's Academy</title>
<link href="./CSS/master.css" rel="stylesheet" type="text/css">
</head>
<body>
<jsp:include page="Header.jsp" />  
	<h1 class="heading">Class Report of ${CLASSNAME}</h1>
	<div class="container">
    <h2>Time : <span class="content">${CLASSTIME}</span> </h2>
	<h2>Taught by: <span class="content">${CLASSTEACHER}</span></h2>
	<h2>Subject : <span class="content">${SUBJECT}</span></h2>
    </div>
	<h2 class="heading_small">List of students</h2>	
	<table class="student master center">
		<tr>
			<th>Roll No.</th>
			<th>Name</th>
		</tr>
		<tr>
			<c:forEach var="tempStudent" items="${STUDENTS_LIST}">
				<tr>
					<td>${tempStudent.id}</td>
					<td>${tempStudent.name}</td>
				</tr>
			</c:forEach>
		</tr>
	</table>
</body>
</html>