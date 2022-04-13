<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>Show Dojo</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<h1>Dojo:</h1>
	<p>
		Name:
		<c:out value="${dojo.name}" />
	</p>
	<p>
		Location:
		<c:out value="${dojo.location}" />
	</p>
	<table class="table table-striped w-100">
		<tr>
			<th scope="col">First Name</th>
			<th scope="col">Last Name</th>
			<th scope="col">Age</th>
		</tr>
		<c:forEach var="oneNinja" items="${dojo.ninjas}">
			<tr>
				<td><c:out value="${oneNinja.firstName}" /></td>
				<td><c:out value="${oneNinja.lastName}" /></td>
				<td><c:out value="${oneNinja.age}" /></td>
			</tr>
		</c:forEach>
	</table>
	<a href="/ninjas/new">Add a ninja</a> |
	<a href="/dojos">Home</a>
</body>
</html>