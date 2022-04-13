<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>Dojos</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div class="container w-100 h-100">
		<h1>New Dojo</h1>
		<div class="container w-25 border border-secondary p-3">
			<form:form action="/dojos/create" method="post"
				modelAttribute="dojo">
				<p>
					<form:label path="name">Name</form:label>
					<form:errors path="name" />
					<form:input path="name" />
				</p>
				<p>
					<form:label path="location">Location</form:label>
					<form:errors path="location" />
					<form:input path="location" />
				</p>
				
				<input type="submit" value="Create" />
			</form:form>
		</div>
		<table class="table table-striped w-100">
			<tr>
				<th scope="col">Location</th>
				<th scope="col">Actions</th>
			</tr>
			<c:forEach var="oneDojo" items="${dojos}">
				<tr>
					<td><c:out value="${oneDojo.location}"></c:out></td>
					<td><a href="/dojos/${oneDojo.id}">See Ninjas</a></td>
				</tr>
			</c:forEach>
		</table>



	</div>

</body>
</html>